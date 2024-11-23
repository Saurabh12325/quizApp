package com.CloudQuest.quizApp.Repository;




import com.CloudQuest.quizApp.Entity.QuestionEntity;
import com.CloudQuest.quizApp.Entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizRepository extends MongoRepository<Quiz,String>{


        }