package com.Reservation.api.demo.model;


import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomid;
    private String roomDesc;
    private Long totalNoOfRooms;
    private Long roomRent;
    private Long occupancyAllowed;
    private Long roomAvailable;
    @ManyToOne


    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public Long getTotalNoOfRooms() {
        return totalNoOfRooms;
    }

    public void setTotalNoOfRooms(Long totalNoOfRooms) {
        this.totalNoOfRooms = totalNoOfRooms;
    }

    public Long getRoomRent() {
        return roomRent;
    }

    public void setRoomRent(Long roomRent) {
        this.roomRent = roomRent;
    }

    public Long getOccupancyAllowed() {
        return occupancyAllowed;
    }

    public void setOccupancyAllowed(Long occupancyAllowed) {
        this.occupancyAllowed = occupancyAllowed;
    }

    public Long getRoomAvailable() {
        return roomAvailable;
    }

    public void setRoomAvailable(Long roomAvailable) {
        this.roomAvailable = roomAvailable;
    }
}
