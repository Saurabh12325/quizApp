package com.CloudQuest.quizApp.DTO.MLRequestDTO;

import lombok.Data;

@Data
public class AverageDTO {
    private float averageScore;
    private float averageCorrectAnswers;
    private float averageIncorrectAnswers;
    private float averageStreak;


}