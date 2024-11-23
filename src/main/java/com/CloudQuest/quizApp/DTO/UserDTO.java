package com.CloudQuest.quizApp.DTO;

import com.CloudQuest.quizApp.Entity.Player;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String username;
    private int score;
    private int correctAnswers;
    private int incorrectAnswers;
    private int streak;

    // Constructor to map from User entity
    public UserDTO(Player player) {
        this.username = player.getUsername();
        this.score = player.getScore();
        this.streak = player.getStreak();
        this.correctAnswers = calculateCorrectAnswers(player.getAnswers());
        this.incorrectAnswers = calculateIncorrectAnswers(player.getAnswers());
    }

    private int calculateCorrectAnswers(List<String> answers) {
        return (int) answers.stream().filter(answer -> answer.equalsIgnoreCase("correct")).count();
    }

    private int calculateIncorrectAnswers(List<String> answers) {
        return answers.size() - calculateCorrectAnswers(answers);
    }


}
