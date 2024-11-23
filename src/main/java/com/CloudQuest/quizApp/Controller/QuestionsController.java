package com.CloudQuest.quizApp.Controller;
import com.CloudQuest.quizApp.Entity.QuestionEntity;
import com.CloudQuest.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("quizzes")
public class QuestionsController {

   @Autowired
   QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {

        return questionService.getAllQuestions();
 }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("difficulty/{difficulty}")
    public  ResponseEntity<List<QuestionEntity>>getQuestionsByDifficulty(@PathVariable String difficulty) {
        return questionService.getQuestionsByDifficulty(difficulty);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion( @RequestBody QuestionEntity questionEntity) {
      return questionService.addQuestion(questionEntity);
    }

}
