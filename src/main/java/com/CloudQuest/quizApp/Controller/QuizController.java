package com.CloudQuest.quizApp.Controller;

import com.CloudQuest.quizApp.DTO.QuizMlRequest;
import com.CloudQuest.quizApp.DTO.QuizSummaryResponse;

import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Entity.User;
import com.CloudQuest.quizApp.Service.MLService.QuizSummaryService;

import com.CloudQuest.quizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
  @Autowired
     QuizSummaryService quizSummaryService;
    @PostMapping("/summary")
    public QuizSummaryResponse getQuizSummary(@RequestBody QuizMlRequest quizMlRequest) {
        return quizSummaryService.getQuizSummary(quizMlRequest);
//        QuizSummaryResponse summary = quizSummaryService.getQuizSummary(quizMlRequest);
//        return ResponseEntity.ok(summary);
    }
    @Autowired
    private QuizService quizService;

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable String quizId) {
        return ResponseEntity.ok(quizService.getQuiz(quizId));
    }

    @PutMapping("/update/{quizId}")
    public ResponseEntity<?> updateQuiz(@PathVariable String quizId, @RequestBody Quiz updatedQuiz) {
        return ResponseEntity.ok(quizService.updateQuiz(quizId, updatedQuiz));
}
}