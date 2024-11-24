package com.CloudQuest.quizApp.Controller;

import com.CloudQuest.quizApp.DTO.playerDTO.PlayerRequestDTO;
import com.CloudQuest.quizApp.DTO.playerDTO.PlayerResponseDTO;
import com.CloudQuest.quizApp.Service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("QuizEntry")
@RequiredArgsConstructor

public class PlayerController{
private final PlayerService playerService;
@PostMapping("/enter")
public ResponseEntity<PlayerResponseDTO> enterQuiz(@RequestBody PlayerRequestDTO playerRequestDTO) {
    try {
        // Call the service to get quiz details
        PlayerResponseDTO playerResponseDTO = playerService.getQuizDetails(playerRequestDTO);
        return new ResponseEntity<>(playerResponseDTO, HttpStatus.OK); // Return quiz title and questions
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // If quiz is not found
    }
}}