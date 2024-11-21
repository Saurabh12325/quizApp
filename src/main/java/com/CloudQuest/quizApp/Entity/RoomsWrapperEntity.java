package com.CloudQuest.quizApp.Entity;

//package com.CloudQuest.quizApp.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "rooms")
public class RoomsWrapperEntity {
    @Id
    private String roomId; // Unique identifier for the wrapper document
    private List<RoomEntity> rooms; // List of RoomEntity objects
}

