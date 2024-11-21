package com.CloudQuest.quizApp.Repository;




import com.CloudQuest.quizApp.Entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz,String>{

        }