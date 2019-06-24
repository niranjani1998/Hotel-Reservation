package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
}
