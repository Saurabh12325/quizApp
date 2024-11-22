package com.CloudQuest.quizApp.Entity;

//package com.CloudQuest.quizApp.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rooms")
public class RoomsWrapperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String roomId; // Unique identifier for the wrapper document
    private List<RoomEntity> rooms; // List of RoomEntity objects
}

