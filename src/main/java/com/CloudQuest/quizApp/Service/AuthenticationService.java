package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.Entity.Admin;
import com.CloudQuest.quizApp.Entity.Player;
import com.CloudQuest.quizApp.Repository.AdminRepository;
import com.CloudQuest.quizApp.Repository.PlayerRepository;
import com.CloudQuest.quizApp.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AdminRepository adminRepository;
    private final PlayerRepository playerRepository;
    private final JwtUtil jwtUtil;

    public AuthenticationService(AdminRepository adminRepository, PlayerRepository playerRepository,
                                 JwtUtil jwtUtil) {
        this.adminRepository = adminRepository;
        this.playerRepository = playerRepository;
        this.jwtUtil = jwtUtil;
    }

    public String registerAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin registered successfully!";
    }

    public String registerPlayer(Player player) {
        playerRepository.save(player);
        return "Player registered successfully!";
    }

    public String authenticateAdmin(String adminId, String password) {
        Admin admin = adminRepository.findByAdminId(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        if (admin.getPassword().equals(password)) {
            return jwtUtil.generateToken(admin.getAdminId(), "ADMIN");
        }
        throw new RuntimeException("Invalid credentials");
    }

    public String authenticatePlayer(String username) {
        Player player = playerRepository.findUsersByUsername(username)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        return jwtUtil.generateToken(player.getUsername(), "PLAYER");
    }
}
