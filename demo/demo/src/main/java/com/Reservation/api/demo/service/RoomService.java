package com.Reservation.api.demo.service;


import com.Reservation.api.demo.model.Hotel;
import com.Reservation.api.demo.model.Room;
import com.Reservation.api.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
    public List<Room> getAllRoom(){
        return (List<Room>)roomRepository.findAll();
//        roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
}
