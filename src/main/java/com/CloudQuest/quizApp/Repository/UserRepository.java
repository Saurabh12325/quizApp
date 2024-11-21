package com.CloudQuest.quizApp.Repository;


import com.CloudQuest.quizApp.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public  interface UserRepository extends MongoRepository<User,Integer> {
    Optional<User> findyUsersByUsername(String username);
}