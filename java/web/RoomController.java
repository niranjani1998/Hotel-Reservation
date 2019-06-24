package com.Reservation.api.demo.web;


import com.Reservation.api.demo.model.Customer;
import com.Reservation.api.demo.model.Hotel;
import com.Reservation.api.demo.model.Room;
import com.Reservation.api.demo.repository.RoomRepository;
import com.Reservation.api.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Room> getRoom() {
        return (List<Room>) roomService.getAllRoom();

    }
    @RequestMapping(value = "/rooms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> createHotel(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        return Optional.ofNullable(createdRoom)
                .map(b -> ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> CreateHotel(@RequestBody Room room) {
        Room CreatedRoom = roomService.createRoom(room);
        return Optional.ofNullable(CreatedRoom)
                .map(b -> ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound().build());

    }
}
