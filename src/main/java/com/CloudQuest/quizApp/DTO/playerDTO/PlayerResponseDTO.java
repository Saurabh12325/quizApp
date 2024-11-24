package com.CloudQuest.quizApp.DTO.playerDTO;

import com.CloudQuest.quizApp.Entity.QuestionEntity;
import lombok.Data;

import java.util.List;
@Data
public class PlayerResponseDTO {
    private String quizTitle;
    private List<QuestionEntity> questions;
}
