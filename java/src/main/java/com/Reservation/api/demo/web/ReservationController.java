package com.Reservation.api.demo.web;


import com.Reservation.api.demo.model.Customer;
import com.Reservation.api.demo.model.Reservation;
import com.Reservation.api.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;


    @RequestMapping(value = "/reservation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reservation> getReservation() {
        return (List<Reservation>) reservationService.getAllReservation();
    }


    @CrossOrigin
    @RequestMapping(value="/reservation",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation ){
        Reservation createdReservation = reservationService.createReservation(reservation);
        return Optional.ofNullable(createdReservation)
                .map(b ->ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound(). build());
    }
    @RequestMapping(value="/reservation",method= RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Reservation> CreateReservation(@RequestBody Reservation reservation ){
        Reservation CreatedReservation = reservationService.createReservation (reservation);
        return Optional.ofNullable(CreatedReservation)
                .map(b ->ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound(). build());
    }
    @RequestMapping(value = "/reservation/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteById(@PathVariable Long id)
    {
        reservationService.deleteById(id);
    }
}
