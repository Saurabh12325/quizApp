package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.DTO.admin.AdminLoginDTO;
import com.CloudQuest.quizApp.DTO.admin.AdminLoginResponseDTO;
import com.CloudQuest.quizApp.DTO.admin.AdminRegisterDTO;
import com.CloudQuest.quizApp.DTO.admin.FetchQuizDTO;
import com.CloudQuest.quizApp.Entity.Admin;
import com.CloudQuest.quizApp.Entity.QuestionEntity;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Repository.AdminRepository;
import com.CloudQuest.quizApp.Repository.FetchRepository;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import com.CloudQuest.quizApp.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
   @Autowired
    private  QuizRepository quizRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    // Admin Registration
    public Admin registerAdmin(AdminRegisterDTO adminRegisterDTO) {
        // Check if the admin already exists
        Optional<Admin> existingAdmin = adminRepository.findByAdminId(adminRegisterDTO.getAdminId());
        log.info("user created");
        if (existingAdmin.isPresent()) {
            throw new RuntimeException("Admin with this email already exists");
        }

        // Create a new Admin entity and populate it from the DTO
        Admin admin = new Admin();
        admin.setAdminId(adminRegisterDTO.getAdminId());
        admin.setPassword(passwordEncoder.encode(adminRegisterDTO.getPassword())); // Encrypt the password

        return adminRepository.save(admin);
    }


public AdminLoginResponseDTO loginAdmin(AdminLoginDTO adminLoginDTO) {
    // Check if the admin exists
    Optional<Admin> admin = adminRepository.findByAdminId(adminLoginDTO.getAdminId());

    if (admin.isPresent() && passwordEncoder.matches(adminLoginDTO.getPassword(), admin.get().getPassword())) {
        // Generate JWT token
        String token = jwtTokenProvider.generateToken(admin.get().getAdminId());

        // Fetch quiz data
        Optional<Quiz> quiz = quizRepository.findByAdminId(admin.get().getAdminId()); // Assuming adminId links quiz

        // Prepare response
        AdminLoginResponseDTO response = new AdminLoginResponseDTO();
        response.setAccessToken(token);

//        if (quiz.isPresent()) {
//            response.setQuizTitle(quiz.get().getQuizTitle());
//            response.setQuizId(quiz.get().getQuizId());
//            response.setPlayers(quiz.get().getPlayers());
//            response.setStatus(quiz.get().isStatus());
//        } else {
//            response.setQuizTitle(null);
//            response.setQuizId(null);
//            response.setPlayers(null);
//            response.setStatus(false);
//        }

        return response;
    } else {
        throw new RuntimeException("Invalid credentials");
}
}

//
//    public  List<FetchQuizDTO> fetchAllQuizData() {
//        List<Quiz> quizzes = quizRepository.findByAdminId(String, adminId); // Fetch all quizzes from the database
//        List<FetchQuizDTO> quizDTOs = new ArrayList<>();
//
//        for (Quiz quiz : quizzes) {
//            FetchQuizDTO dto = new FetchQuizDTO();
//            dto.setAdminId(quiz.getAdminId());
//            dto.setQuizTitle(quiz.getQuizTitle());
//            dto.setQuizId(quiz.getQuizId());
//            dto.setPlayers(quiz.getPlayers()); // Assuming players are stored as a list in the Quiz entity
//            dto.setStatus(quiz.isStatus());
//            quizDTOs.add(dto);
//        }
//
//        return quizDTOs; //
//
//    }

}
