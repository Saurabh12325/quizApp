package com.CloudQuest.quizApp.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Average {
    private int averageScore;
    private int averageCorrectAnswers;
    private int averageIncorrectAnswers;
    private int averageStreak;
}

