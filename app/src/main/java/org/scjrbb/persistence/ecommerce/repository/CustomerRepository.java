package org.scjrbb.persistence.ecommerce.repository;

import org.scjrbb.persistence.ecommerce.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{id: '?0'")
    List<Customer> findAll(String customer);

    public long count();
}
