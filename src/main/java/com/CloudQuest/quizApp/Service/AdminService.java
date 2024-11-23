package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.DTO.admin.AdminLoginDTO;
import com.CloudQuest.quizApp.DTO.admin.AdminRegisterDTO;
import com.CloudQuest.quizApp.Entity.Admin;
import com.CloudQuest.quizApp.Repository.AdminRepository;
import com.CloudQuest.quizApp.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public AdminService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Admin Registration
    public Admin registerAdmin(AdminRegisterDTO adminRegisterDTO) {
        // Check if the admin already exists
        Optional<Admin> existingAdmin = adminRepository.findByAdminId(adminRegisterDTO.getAdminId());
        if (existingAdmin.isPresent()) {
            throw new RuntimeException("Admin with this email already exists");
        }

        // Create a new Admin entity and populate it from the DTO
        Admin admin = new Admin();
        admin.setAdminId(adminRegisterDTO.getAdminId());
        admin.setPassword(passwordEncoder.encode(adminRegisterDTO.getPassword())); // Encrypt the password

        return adminRepository.save(admin);
    }

    // Admin Login
    public String loginAdmin(AdminLoginDTO adminLoginDTO) {
        // Check if the admin exists
        Optional<Admin> admin = adminRepository.findByAdminId(adminLoginDTO.getAdminId());

        if (admin.isPresent() && passwordEncoder.matches(adminLoginDTO.getPassword(), admin.get().getPassword())) {
            // Generate and return JWT token
            return jwtTokenProvider.generateToken(admin.get().getAdminId());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
