package org.scjrbb.persistence.ecommerce.repository;

import org.scjrbb.persistence.ecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{id: '?0'")
    List<Product> findAll(String product);

    public long count();

}
