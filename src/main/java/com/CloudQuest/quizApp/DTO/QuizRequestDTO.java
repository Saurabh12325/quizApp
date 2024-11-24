package com.CloudQuest.quizApp.DTO;

import com.CloudQuest.quizApp.Entity.QuestionEntity;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QuizRequestDTO {
    private String quizId;
    private String quizTitle;
    private String adminId;
    private List<QuestionEntity> questions;
}
