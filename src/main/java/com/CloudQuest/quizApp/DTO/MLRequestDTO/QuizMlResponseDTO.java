package com.CloudQuest.quizApp.DTO.MLRequestDTO;

import lombok.Data;

import java.util.List;
@Data
public class QuizMlResponseDTO {

        private List<String> feedback;
        private List<AnalysisDTO> analysis;
        private String graph;

        public QuizMlResponseDTO() {}
    }


