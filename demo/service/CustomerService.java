package com.Reservation.api.demo.service;

import com.Reservation.api.demo.model.Customer;
import com.Reservation.api.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public  void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public  Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);

    }





   /* public  Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }*/


    public List<Customer> getAllCustomer(){
        return (List<Customer>) customerRepository.findAll();
    }

    /*public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }*/
}
