package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Customer;
import com.Reservation.api.demo.model.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelRepository extends CrudRepository<Hotel,Long> {

}
