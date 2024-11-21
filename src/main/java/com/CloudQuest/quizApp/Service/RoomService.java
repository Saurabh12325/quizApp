package com.CloudQuest.quizApp.Service;



import com.CloudQuest.quizApp.Entity.RoomEntity;
import com.CloudQuest.quizApp.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomEntity createRoom(RoomEntity room) {
        return roomRepository.save(room);
    }

    public RoomEntity getRoomDetails(String roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
}
}
