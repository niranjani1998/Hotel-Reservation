package com.Reservation.api.demo.web;


import com.Reservation.api.demo.model.Booking;
import com.Reservation.api.demo.model.Reservation;
import com.Reservation.api.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @RequestMapping(value = "/booking", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Booking> getBooking() {
        return (List<Booking>) bookingService.getAllBooking();
    }



    @RequestMapping(value="/booking",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking ){
        Booking createdBooking = bookingService.createBooking(booking);
        return Optional.ofNullable(createdBooking)
                .map(b ->ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound(). build());
    }
    @RequestMapping(value="/booking",method= RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Booking> CreateBooking(@RequestBody Booking booking ){
        Booking CreatedBooking = bookingService.createBooking (booking);
        return Optional.ofNullable(CreatedBooking)
                .map(b ->ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound(). build());
    }
    @RequestMapping(value = "/booking/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteById(@PathVariable Long id)
    {
        bookingService.deleteById(id);
    }
}
