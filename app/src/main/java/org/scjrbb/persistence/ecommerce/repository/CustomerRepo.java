package org.scjrbb.persistence.ecommerce.repository;

import org.scjrbb.persistence.ecommerce.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer, Integer> {}
