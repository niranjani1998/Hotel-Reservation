package com.Reservation.api.demo.service;



import com.Reservation.api.demo.model.Hotel;
import com.Reservation.api.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotel(){
        return (List<Hotel>) hotelRepository.findAll();
    }
}
