package com.CloudQuest.quizApp.DTO;


import lombok.Data;

import java.util.List;
@Data
public class QuizSummaryRequest {
    private List<UserDTO> userData;
    private Average average;
}
