//package com.CloudQuest.quizApp.Controller;
//import com.CloudQuest.quizApp.DTO.QuizMlRequest;
//import com.CloudQuest.quizApp.DTO.QuizSummaryResponse;
//import com.CloudQuest.quizApp.Entity.Player;
//import com.CloudQuest.quizApp.Entity.Quiz;
//
//import com.CloudQuest.quizApp.Service.QuizSummaryService;
//import com.CloudQuest.quizApp.Service.QuizService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("quiz")
//public class QuizController {
//
//    private final QuizSummaryService quizSummaryService;
//
//    @Autowired
//    public QuizController(QuizSummaryService quizSummaryService) {
//        this.quizSummaryService = quizSummaryService;
//    }
//    @PostMapping("/summary")
//    public QuizSummaryResponse getQuizSummary(
//            @RequestBody List<Player> users,
//            @RequestBody QuizMlRequest.Averages average
//    ) {
//        return quizSummaryService.getQuizSummary(users, average);
//    }
//    @Autowired
//    private QuizService quizService;
//
//    @GetMapping("/{quizId}")
//    public ResponseEntity<?> getQuiz(@PathVariable String quizId) {
//        return ResponseEntity.ok(quizService.getQuiz(quizId));
//    }
//
//    @PutMapping("/update/{quizId}")
//    public ResponseEntity<?> updateQuiz(@PathVariable String quizId, @RequestBody Quiz updatedQuiz) {
//        return ResponseEntity.ok(quizService.updateQuiz(quizId, updatedQuiz));
//}
//}