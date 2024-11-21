package com.CloudQuest.quizApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoomEntity {
    private String quizKey;
    private String roomStatus;
    private List<String> user;
}