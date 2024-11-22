package com.CloudQuest.quizApp.Entity;

import jakarta.persistence.ElementCollection;
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
    private String quizId; // Unique id for the quiz or paskey
    private String adminID; // Admin who created the quiz
    private String quizTitle; // Title of the quiz
    private boolean status; //quiz start or not
    private List<Map<String, QuestionEntity>>questions; // this is the list of questiion

}