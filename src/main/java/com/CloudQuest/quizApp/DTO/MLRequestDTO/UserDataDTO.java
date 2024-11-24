package com.CloudQuest.quizApp.DTO.MLRequestDTO;

import lombok.Data;

@Data
public class UserDataDTO {
    private String username;
    private int score;
    private int correctAnswers;
    private int incorrectAnswers;
    private int streak;

}
