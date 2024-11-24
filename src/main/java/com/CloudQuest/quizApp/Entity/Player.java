package com.CloudQuest.quizApp.Entity;
import jakarta.persistence.*;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;
import java.util.Map;

@Entity
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String quizId;
  private String username;
  @ElementCollection
  private List<String> answers;
  private int score;
  private int streak;



}