package com.CloudQuest.quizApp.DTO.admin;

import lombok.Data;

import java.util.List;
@Data
public class FetchQuizDTO {
    private String quizTitle;
    private String quizId;
    private List<String> players;
    private boolean status;
}
