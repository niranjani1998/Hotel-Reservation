package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findByCustomerNameAndPassword(String customerName,String password);
}
