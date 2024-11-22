package com.CloudQuest.quizApp.Repository;


import com.CloudQuest.quizApp.Entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public  interface PlayerRepository extends MongoRepository<Player,Integer> {
    Optional<Player> findUsersByUsername(String username);
}