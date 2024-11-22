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
    private String quizId;
    private String adminID;
    private String quizTitle;
    private List<Map<String, QuestionEntity>>questions;

}