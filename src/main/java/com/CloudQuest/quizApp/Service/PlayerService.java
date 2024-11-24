package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.DTO.playerDTO.PlayerRequestDTO;
import com.CloudQuest.quizApp.DTO.playerDTO.PlayerResponseDTO;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final QuizRepository quizRepository;

    // Method to get quiz and questions
    public PlayerResponseDTO getQuizDetails(PlayerRequestDTO playerRequestDTO) {
        Quiz quiz = quizRepository.findByQuizId(playerRequestDTO.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Prepare the response DTO
        PlayerResponseDTO playerResponseDTO = new PlayerResponseDTO();
        playerResponseDTO.setQuizTitle(quiz.getQuizTitle());
        playerResponseDTO.setQuestions(quiz.getQuestions());

        return playerResponseDTO;
}
}