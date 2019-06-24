package com.Reservation.api.demo.model;


import javax.persistence.*;


import java.time.LocalDate;


@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingid;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long noOfRooms;
    private LocalDate bookingdate;
    private LocalDate cancellationDate;
    private Long refundAmount;
    private String paymentDesc;

    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "hotelid",referencedColumnName = "hotelid")
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name = "roomid",referencedColumnName = "roomid")
    private Room room;

    @OneToOne
    @JoinColumn(name = "paymentid",referencedColumnName = "paymentid")
    private Payment payment;


    public Long getBookingid() {
        return bookingid;
    }

    public void setBookingid(Long bookingid) {
        this.bookingid = bookingid;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Long getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Long noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public LocalDate getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(LocalDate bookingdate) {
        this.bookingdate = bookingdate;
    }

    public LocalDate getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getPaymentDesc() {
        return paymentDesc;
    }

    public void setPaymentDesc(String paymentDesc) {
        this.paymentDesc = paymentDesc;
    }
}
