package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel,Long> {
}
