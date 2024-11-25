package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.DTO.MLRequestDTO.UserDataDTO;
import com.CloudQuest.quizApp.DTO.playerDTO.PlayerRequestDTO;
import com.CloudQuest.quizApp.DTO.playerDTO.PlayerResponseDTO;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Repository.PlayerRepository;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final QuizRepository quizRepository;

    private final  PlayerRepository playerRepository;


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
    // Save UserData to the database
    public UserDataDTO saveUserData(UserDataDTO userDataDTO) {
        return playerRepository.save(userDataDTO);
    }

    // Fetch all records by username
    public List<UserDataDTO> findAllByUsername(String username) {
        return playerRepository.findAllByUsername(username);
    }
}