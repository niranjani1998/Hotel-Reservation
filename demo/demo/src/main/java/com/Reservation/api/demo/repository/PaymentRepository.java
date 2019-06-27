package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment ,Long> {
}
