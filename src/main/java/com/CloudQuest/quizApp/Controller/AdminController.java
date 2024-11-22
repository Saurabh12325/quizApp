package com.CloudQuest.quizApp.Controller;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

<<<<<<< HEAD
    @Autowired
=======
@Autowired
>>>>>>> 2f902f6fdc72df05279f9558835e5cc6b662e7a9
    private AdminService adminService;

    @PostMapping("/create-quiz")
    public ResponseEntity<?> createQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(adminService.createQuiz(quiz));
    }

    @DeleteMapping("/delete-quiz/{quizId}")
    public ResponseEntity<?> deleteQuiz(@PathVariable String quizId) {
        adminService.deleteQuiz(quizId);
        return ResponseEntity.ok("Quiz deleted successfully.");
    }
}