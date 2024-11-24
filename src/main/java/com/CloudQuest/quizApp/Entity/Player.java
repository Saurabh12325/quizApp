package com.CloudQuest.quizApp.Entity;
import jakarta.persistence.*;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;
import java.util.Map;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


@Document(collection = "players")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String quizId;
  private String username;
  @ElementCollection
  private List<String> answers;
  private int correctAnswers;
  private int  wrongAnswers;
  private int score;
  private int streak;
  private float averageScore;
  private float averageCorrectAnswers;
  private float averageIncorrectAnswers;
  private float averageStreak;
}