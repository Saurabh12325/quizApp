package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.DTO.QuizRequestDTO;
import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public Quiz createQuiz(QuizRequestDTO quizRequestDTO) {
        Quiz quiz = new Quiz();
        quiz.setQuizId(quizRequestDTO.getQuizId());
        quiz.setAdminId(quizRequestDTO.getAdminId());
        quiz.setQuizTitle(quizRequestDTO.getQuizTitle());
        quiz.setQuestions(quizRequestDTO.getQuestions());
        return quizRepository.save(quiz);
    }
}