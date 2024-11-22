package com.CloudQuest.quizApp.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class QuizSummaryResponse {
    private List<Analysis> analysis;
    private List<String> feedback;

    // Inner class
  @Data
  @Getter
  @Setter
    public class Analysis {
        private String username;
        private String analysis;
    }
    }

