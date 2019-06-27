package com.Reservation.api.demo.service;

import com.Reservation.api.demo.model.Customer;
import com.Reservation.api.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public  void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
    public Boolean authUser(String customerName,String password)
    {
        Optional<Customer> customerOptional=customerRepository.findByCustomerNameAndPassword(customerName,password);
        if(customerOptional.isPresent()){
            return true;
        }
        return false;
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
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

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /*public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }*/
}
