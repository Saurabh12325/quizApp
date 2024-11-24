package com.CloudQuest.quizApp.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String quizId; // Unique id for the quiz
    private Admin adminId; // Admin who created the quiz
    private String quizTitle; // Title of the quiz
    private boolean status;
    private List<String> players;
    private List<QuestionEntity> questions;
    private List<Map<String, QuestionEntity>> question;


}