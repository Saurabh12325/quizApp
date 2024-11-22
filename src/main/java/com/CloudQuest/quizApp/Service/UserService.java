package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Entity.User;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import com.CloudQuest.quizApp.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    public  User registerUser(User user) {
        return userRepository.save(user);
    }

    public  String submitQuiz(String quizId, User user) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        int score = calculateScore(quiz, user);
        user.setScore(score);
        userRepository.save(user);
        return "Quiz submitted. Your score is: " + score;
    }

    private int calculateScore(Quiz quiz, User user) {
        // Logic to calculate score
        return 0;
    }
}