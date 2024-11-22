package com.CloudQuest.quizApp.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "quizquestions")
public class QuestionEntity {
 @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String quesKey;
    private String questionText;
    @ElementCollection
    private List<String> options;
    private String correctAnswer;
 private String category;
    private String difficulty;



}

