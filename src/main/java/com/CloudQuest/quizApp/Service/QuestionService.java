package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.Repository.QuestionRepoDao;
import com.CloudQuest.quizApp.Entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
            return new ResponseEntity<>(questionRepoDao.findAll(), HttpStatus.OK);
        }catch(Exception e) {
          e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepoDao.findByCategory(category),HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);   

    }

    public ResponseEntity<String> addQuestion(QuestionEntity questionEntity) {
         questionRepoDao.save(questionEntity);
         return new ResponseEntity<>("Question added", HttpStatus.CREATED);
    }

    public  ResponseEntity<List<QuestionEntity>> getQuestionsByDifficulty(String difficulty) {
        try{
            return new ResponseEntity<>(questionRepoDao.findByDifficulty(difficulty),HttpStatus.OK);
        } catch (Exception e) {
           e.printStackTrace();
        }
      return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }


}
