package com.CloudQuest.quizApp.Controller;

import com.CloudQuest.quizApp.Entity.RoomEntity;
import com.CloudQuest.quizApp.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("rooms")

public class RoomController{
    @Autowired
  private RoomService roomService;

    @PostMapping("/create")

    public ResponseEntity<?> createRoom(@RequestBody RoomEntity roomEntity) {
        return ResponseEntity.ok(roomService.createRoom(roomEntity));
    }
    @GetMapping("/{roomId}")
    public ResponseEntity<?> getRoomDetails(@PathVariable String roomId) {
        return ResponseEntity.ok(roomService.getRoomDetails(roomId));

    }

}