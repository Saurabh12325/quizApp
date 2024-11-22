package com.CloudQuest.quizApp.Repository;
import com.CloudQuest.quizApp.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin,String> {

}
