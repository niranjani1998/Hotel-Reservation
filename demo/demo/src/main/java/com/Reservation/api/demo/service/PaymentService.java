package com.Reservation.api.demo.service;

import com.Reservation.api.demo.model.Payment;
import com.Reservation.api.demo.model.Room;
import com.Reservation.api.demo.repository.PaymentRepository;
import com.Reservation.api.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    public List<Payment> getAllPayment(){
        return (List<Payment>)paymentRepository.findAll();
    }


    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
