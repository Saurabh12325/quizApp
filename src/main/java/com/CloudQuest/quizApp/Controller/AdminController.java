package com.CloudQuest.quizApp.Controller;
import com.CloudQuest.quizApp.DTO.QuizRequestDTO;
import com.CloudQuest.quizApp.DTO.admin.AdminLoginDTO;

import com.CloudQuest.quizApp.DTO.admin.AdminLoginResponseDTO;
import com.CloudQuest.quizApp.DTO.admin.AdminRegisterDTO;
import com.CloudQuest.quizApp.DTO.admin.FetchQuizDTO;
import com.CloudQuest.quizApp.Entity.Admin;

import com.CloudQuest.quizApp.Entity.QuestionEntity;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Service.AdminService;
import com.CloudQuest.quizApp.Service.QuizService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;
    private final QuizService quizService;

    // Admin Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminRegisterDTO adminRegisterDTO) {
        try {
            Admin admin = new Admin();
            admin.setAdminId(adminRegisterDTO.getAdminId());
            admin.setPassword(adminRegisterDTO.getPassword());
            Admin createdAdmin = adminService.registerAdmin(adminRegisterDTO);
            log.info("Created successfully" + createdAdmin.toString());
            return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>("Already registered", HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {
        try {
            AdminLoginResponseDTO response = adminService.loginAdmin(adminLoginDTO);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/createQuiz")
    public ResponseEntity<?> createQuiz(@RequestBody QuizRequestDTO quizRequestDTO) {
        if (quizService.existsByAdminId(quizRequestDTO.getAdminId())) {
            return new ResponseEntity<>("A quiz already exists for the provided adminId.", HttpStatus.BAD_REQUEST);
}
        try {
            Quiz createdQuiz = quizService.createQuiz(quizRequestDTO);
            return new ResponseEntity<>(createdQuiz, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/fetchQuiz")
    public ResponseEntity<?> fetchQuizByAdminId(@RequestParam String adminId) {
        try {

            Optional<Quiz> quiz = quizService.getQuizByAdminId(adminId);
            if (quiz != null) {
                return new ResponseEntity<>(quiz, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No quiz found for the provided adminId.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
}
}

