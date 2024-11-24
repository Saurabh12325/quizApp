package com.CloudQuest.quizApp.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "admin")
public class Admin {
    @Id
    private String id;
    @ElementCollection
    private List<String> quizId; //list of quiz id manage by admin
    private String adminId;  // for singup email and pass
    private String password;
//hello
}