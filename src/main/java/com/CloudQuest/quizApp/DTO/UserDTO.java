package com.CloudQuest.quizApp.DTO;

import com.CloudQuest.quizApp.Entity.User;
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
    public UserDTO(User user) {
        this.username = user.getUsername();
        this.score = user.getScore();
        this.streak = user.getStreak();
        this.correctAnswers = calculateCorrectAnswers(user.getAnswers());
        this.incorrectAnswers = calculateIncorrectAnswers(user.getAnswers());
    }

    private int calculateCorrectAnswers(List<String> answers) {
        return (int) answers.stream().filter(answer -> answer.equalsIgnoreCase("correct")).count();
    }

    private int calculateIncorrectAnswers(List<String> answers) {
        return answers.size() - calculateCorrectAnswers(answers);
    }


}
