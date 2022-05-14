package org.scjrbb.persistence.ecommerce.repository;

import java.util.List;

import org.scjrbb.persistence.ecommerce.model.Order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{id: '?0'")
    List<Order> findAll(String order);

    public long count();

}