package org.scjrbb.persistence.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.scjrbb.persistence.ecommerce.model.Product;
import org.scjrbb.persistence.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product Added to Database. No, really.";
    }

    @DeleteMapping("/product/{id}")
    public String removeProduct(@PathVariable String id) {
        productRepository.deleteById(id);
        return "I deleted this Product. Yep. It's done. Too late now.";
    }

}
