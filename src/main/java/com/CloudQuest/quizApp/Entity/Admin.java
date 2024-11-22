package com.CloudQuest.quizApp.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "admin")
public class Admin {
    @Id
    private String id;
    private String quizId;
    private String adminId;  // for singup email and pass
    private String password;
    private String authToken;
}