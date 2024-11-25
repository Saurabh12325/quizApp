package com.CloudQuest.quizApp.Controller;

import com.CloudQuest.quizApp.DTO.MLRequestDTO.UserDataDTO;
import com.CloudQuest.quizApp.DTO.playerDTO.PlayerRequestDTO;
import com.CloudQuest.quizApp.DTO.playerDTO.PlayerResponseDTO;
import com.CloudQuest.quizApp.Repository.PlayerRepository;
import com.CloudQuest.quizApp.Service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("QuizEntry")
@RequiredArgsConstructor

public class PlayerController{
private final PlayerService playerService;
private final PlayerRepository playerRepository;
@PostMapping("/enter")
public ResponseEntity<PlayerResponseDTO> enterQuiz(@RequestBody PlayerRequestDTO playerRequestDTO) {
    try {

        PlayerResponseDTO playerResponseDTO = playerService.getQuizDetails(playerRequestDTO);
        return new ResponseEntity<>(playerResponseDTO, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}

    @PostMapping("/SavePlayerData")
    public UserDataDTO saveUserData(@RequestBody UserDataDTO userDataDTO) {
        return playerService.saveUserData(userDataDTO);
    }

    // Endpoint to fetch all user data by username
//    @GetMapping("/findAll")
//    public List<UserDataDTO> findAllData(@RequestBody UserDataDTO userDataDTO) {
//        return playerService.findAllData(userDataDTO);
//    }
    @GetMapping("/findAll")
    public List<UserDataDTO> getAllPlayers() {
        return playerRepository.findAll();
}
}