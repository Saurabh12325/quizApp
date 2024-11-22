package com.CloudQuest.quizApp.Controller;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
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