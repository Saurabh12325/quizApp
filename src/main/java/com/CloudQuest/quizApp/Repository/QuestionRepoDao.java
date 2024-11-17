package com.CloudQuest.quizApp.Repository;

import com.CloudQuest.quizApp.Entity.QuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepoDao extends MongoRepository<QuestionEntity, Integer> {
  List<QuestionEntity> findByCategory(String category);
  List<QuestionEntity> findByDifficulty(String difficulty);
}



