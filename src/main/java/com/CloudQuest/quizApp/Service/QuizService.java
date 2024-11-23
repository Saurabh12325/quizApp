package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.Entity.Quiz;
import com.CloudQuest.quizApp.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;
    public Quiz getQuiz(String quizId) {
        return quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
    }
    public Quiz updateQuiz(String quizId, Quiz updatedQuiz) {
        Quiz existingQuiz = getQuiz(quizId);
        existingQuiz.setQuizTitle(updatedQuiz.getQuizTitle());
        existingQuiz.setQuestions(updatedQuiz.getQuestions());
        return quizRepository.save(existingQuiz);
}
}