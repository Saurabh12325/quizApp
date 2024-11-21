package com.CloudQuest.quizApp.DTO;


import lombok.Data;

import java.util.List;
@Data
public class QuizSummaryResponse {

    private List<Analysis> analysis;
    private List<String> feedback;
@Data
    public static class Analysis {
        private String username;
        private String analysis;

    }


}
