package com.CloudQuest.quizApp.Repository;


import com.CloudQuest.quizApp.DTO.MLRequestDTO.UserDataDTO;
import com.CloudQuest.quizApp.Entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public  interface PlayerRepository extends MongoRepository<UserDataDTO,String> {

}