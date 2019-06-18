package com.Reservation.api.demo.service;

import com.Reservation.api.demo.model.Reservation;
import com.Reservation.api.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAllReservation(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
