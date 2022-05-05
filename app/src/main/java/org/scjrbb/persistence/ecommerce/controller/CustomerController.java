package org.scjrbb.persistence.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.scjrbb.persistence.ecommerce.model.Customer;
import org.scjrbb.persistence.ecommerce.repository.CustomerRepository;

@RestController

public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable String id) {
        return customerRepository.findById(id);
    }

    @PostMapping("/customer")
    public String addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Customer Added to Database. No, really.";
    }

    @DeleteMapping("/customer/{id}")
    public String removeCustomer(@PathVariable String id) {
        customerRepository.deleteById(id);
        return "I deleted this Customer. Yep. It's done. Too late now.";
    }


}