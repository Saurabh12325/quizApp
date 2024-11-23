//package com.CloudQuest.quizApp.Controller;
//import com.CloudQuest.quizApp.Entity.Player;
//import com.CloudQuest.quizApp.Service.PlayerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class PlayerController {
//    @Autowired
//    private PlayerService userService;
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody Player player) {
//        return ResponseEntity.ok(userService.registerUser(player));
//    }
//    @PostMapping("/submit-quiz/{quizId}")
//    public ResponseEntity<?> submitQuiz(@PathVariable String quizId, @RequestBody Player user) {
//        return ResponseEntity.ok(userService.submitQuiz(quizId, user));
//    }
//}
//
//
