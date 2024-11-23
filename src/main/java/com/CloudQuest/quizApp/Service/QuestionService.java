package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.Repository.QuestionRepoDao;
import com.CloudQuest.quizApp.Entity.QuestionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component

public class QuestionService {
     @Autowired
    QuestionRepoDao questionRepoDao;

    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        try {
            List<QuestionEntity> questions = questionRepoDao.findAll();
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(String category) {
        try {
            List<QuestionEntity> questions = questionRepoDao.findByCategory(category);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuestionEntity>> getQuestionsByDifficulty(String difficulty) {
        try {
            List<QuestionEntity> questions = questionRepoDao.findByDifficulty(difficulty);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addQuestion(QuestionEntity questionEntity) {
        try {
            questionRepoDao.save(questionEntity);
            return new ResponseEntity<>("Question added", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error adding question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
