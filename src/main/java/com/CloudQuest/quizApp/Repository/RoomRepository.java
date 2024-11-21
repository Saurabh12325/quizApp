package com.CloudQuest.quizApp.Repository;




import com.CloudQuest.quizApp.Entity.RoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<RoomEntity,String>{
        }