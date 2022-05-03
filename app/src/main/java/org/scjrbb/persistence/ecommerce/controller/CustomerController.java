package org.scjrbb.persistence.ecommerce.controller;

import org.scjrbb.persistence.ecommerce.model.Customer;
import org.scjrbb.persistence.ecommerce.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RestController

public class CustomerController {
    @Autowired
    private CustomerRepo repo;

    @PostMapping("/addCustomer")
    public String saveCustomer(@RequestBody Customer customer) {
        repo.save(customer);
        return "Customer added successfully";
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        repo.deleteById(id);
        return "Customer Deleted Successfully";
    }
    
}
