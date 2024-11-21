package com.CloudQuest.quizApp.Controller;



import com.CloudQuest.quizApp.Entity.User;
import com.CloudQuest.quizApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/submit-quiz/{quizId}")
    public ResponseEntity<?> submitQuiz(@PathVariable String quizId, @RequestBody User user) {
        return ResponseEntity.ok(userService.submitQuiz(quizId, user));
    }
}


