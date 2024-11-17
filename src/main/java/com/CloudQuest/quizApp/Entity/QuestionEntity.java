package com.CloudQuest.quizApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "quizquestions")
public class QuestionEntity {
 @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

 private  String _id;
    private Long key;
    private String question_text;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String right_answer;
    private String difficulty;
    private String category;
}

