package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Entity.Player;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import com.CloudQuest.quizApp.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    public Player registerUser(Player user) {
        return userRepository.save(user);
    }

    public   String submitQuiz(String quizId, Player user) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        int score = calculateScore(quiz, user);
        user.setScore(score);
        userRepository.save(user);
        return "Quiz submitted. Your score is: " + score;
    }

    private int calculateScore(Quiz quiz, Player user) {
        return 0;
    }
}