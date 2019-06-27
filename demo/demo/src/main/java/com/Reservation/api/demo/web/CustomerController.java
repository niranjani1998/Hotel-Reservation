package com.Reservation.api.demo.web;


import com.Reservation.api.demo.model.Customer;
import com.Reservation.api.demo.repository.CustomerRepository;
import com.Reservation.api.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class CustomerController {
    @Autowired
    private CustomerService customerService;


     @CrossOrigin
     @RequestMapping(value = "/Customers/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public Boolean checkCustomer(@RequestBody Customer customer)
     {
         return customerService.authUser(customer.getCustomerName(),customer.getPassword());
     }
    @RequestMapping(value = "/Customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Customer> getCustomer() {
        return (List<Customer>) customerService.getAllCustomer();
    }

    @CrossOrigin
    @RequestMapping(value="/Customers",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer ){
        Customer createdCustomer = customerService.createCustomer(customer);
        return Optional.ofNullable(createdCustomer)
                .map(b ->ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound(). build());
    }

    @CrossOrigin
    @RequestMapping(value="/Customers",method= RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer ){
        Customer updatedCustomer = customerService.updateCustomer (customer);
        return Optional.ofNullable(updatedCustomer)
                .map(b ->ResponseEntity.ok().body(b))
                .orElse(ResponseEntity.notFound(). build());
    }
    @RequestMapping(value = "/Customers/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteById(@PathVariable Long id)
    {
        customerService.deleteById(id);
    }
}