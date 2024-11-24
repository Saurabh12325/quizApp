package com.CloudQuest.quizApp.Repository;

import com.CloudQuest.quizApp.DTO.admin.FetchQuizDTO;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FetchRepository extends MongoRepository <FetchQuizDTO, String>{

}
