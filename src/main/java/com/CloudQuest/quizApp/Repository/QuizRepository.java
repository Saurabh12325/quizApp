package com.CloudQuest.quizApp.Repository;




import com.CloudQuest.quizApp.Entity.QuestionEntity;
import com.CloudQuest.quizApp.Entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface QuizRepository extends MongoRepository<Quiz,String>{
    Optional<Quiz> findByAdminId(String adminId);
}