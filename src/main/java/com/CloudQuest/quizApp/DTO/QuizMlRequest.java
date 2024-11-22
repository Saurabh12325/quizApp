package com.CloudQuest.quizApp.DTO;

import lombok.*;

import java.util.List;
@Data
@Setter
@Getter
    public class QuizMlRequest {
        private List<UserData> userData;
        private Averages averages;

        // Inner classes

        @Data
        @Setter
        @Getter
        public static class UserData {
            private String username;
            private int score;
            private int correct_answers;
            private int incorrect_answers;
            private int streak;
        }


   @Data
   @Setter
   @Getter
        public static class Averages {
            private int average_score;
            private int average_correct_answers;
            private int average_incorrect_answers;
            private int average_streak;


        }
    }


