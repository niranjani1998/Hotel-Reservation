package com.Reservation.api.demo.service;



import com.Reservation.api.demo.model.Hotel;
import com.Reservation.api.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Hotel> getHotelById(Long hotelid) {
        return hotelRepository.findById(hotelid);
    }

    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }


}
