package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Long> {
}
