package com.Reservation.api.demo.service;

import com.Reservation.api.demo.model.Booking;
import com.Reservation.api.demo.model.Reservation;
import com.Reservation.api.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    public List<Booking> getAllBooking() {
        return (List<Booking>) bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }
}


