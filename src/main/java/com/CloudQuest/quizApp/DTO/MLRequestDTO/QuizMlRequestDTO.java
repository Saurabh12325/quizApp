package com.CloudQuest.quizApp.DTO.MLRequestDTO;

import lombok.Data;

import java.util.List;
@Data
public class QuizMlRequestDTO {
    private List<UserDataDTO> userData;
    private AverageDTO average;
}
