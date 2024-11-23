package com.CloudQuest.quizApp.Repository;

import com.CloudQuest.quizApp.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin, String> {
        Optional<Admin> findByAdminId(String adminId);  // Find an admin by their adminId (email)
}
