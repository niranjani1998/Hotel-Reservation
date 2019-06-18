package com.Reservation.api.demo.repository;

import com.Reservation.api.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
