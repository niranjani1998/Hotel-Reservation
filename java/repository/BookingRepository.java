package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking,Long> {
}
