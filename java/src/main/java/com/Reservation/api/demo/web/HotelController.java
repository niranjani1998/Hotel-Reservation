package com.Reservation.api.demo.web;


import com.Reservation.api.demo.model.Hotel;
import com.Reservation.api.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelController {
    @Autowired
    private HotelService hotelService;



    @CrossOrigin
    @RequestMapping(value = "/hotel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Hotel> getHotel() {
        return (List<Hotel>) hotelService.getAllHotel();
    }



    @RequestMapping(value = "/hotel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return Optional.ofNullable(createdHotel)
                .map(b -> ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound().build());
    }

//    @RequestMapping(value = "/hotel", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
//        Hotel CreatedHotel = hotelService.createHotel(hotel);
//        return Optional.ofNullable(CreatedHotel)
//                .map(b -> ResponseEntity.ok().body(b))
//                .orElse(ResponseEntity.notFound().build());
//    }


    @CrossOrigin
    @GetMapping(value = "/hotel/{hotelid}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelid){
        Optional<Hotel> optionalHotel = hotelService.getHotelById(hotelid);
        if (optionalHotel.isPresent()) {
            return new ResponseEntity<>(optionalHotel.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

