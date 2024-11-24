package com.CloudQuest.quizApp.DTO.admin;

import lombok.Data;

import java.util.List;

@Data
public class AdminLoginResponseDTO {
    private String accessToken; // New field for JWT
}
