package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.DTO.QuizRequestDTO;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {
@Autowired
    private  QuizRepository quizRepository;

    public boolean existsByAdminId(String adminId) {
        return quizRepository.existsByAdminId(adminId);  // Check if a quiz exists for the given adminId
    }


    public Quiz createQuiz(QuizRequestDTO quizRequestDTO) {
        Quiz quiz = new Quiz();
        quiz.setQuizId(quizRequestDTO.getQuizId());
        quiz.setAdminId(quizRequestDTO.getAdminId());
        quiz.setQuizTitle(quizRequestDTO.getQuizTitle());
        quiz.setQuestions(quizRequestDTO.getQuestions());
        return quizRepository.save(quiz);
    }


    public Optional<Quiz> getQuizByAdminId(String adminId) {
        return quizRepository.findByAdminId(adminId);
}
}