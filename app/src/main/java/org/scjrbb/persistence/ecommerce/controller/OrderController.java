package org.scjrbb.persistence.ecommerce.controller;

import java.util.Optional;

import org.scjrbb.persistence.ecommerce.model.Customer;
import org.scjrbb.persistence.ecommerce.model.Order;
import org.scjrbb.persistence.ecommerce.model.dto.OrderDto;
import org.scjrbb.persistence.ecommerce.repository.CustomerRepository;
import org.scjrbb.persistence.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Inserção de uma venda
    @PostMapping("/order")
    public Order addOrder(@RequestBody OrderDto orderDto) {

        // Recebo uma dto da ordem e tenho que transformar num objeto ordem;
        Order order = new Order();

        Optional<Customer> customer = customerRepository.findById(orderDto.getClientID());
        if (customer != null) {
            order.setCustomer(customer.get());
        } else {
            throw new Error("Não foi possivel adicionar a venda cliente inexitente");
        }

        return order;
        // pegar o codigo do cliente e adicionar o objeto cliente na ordem

        // productRepository.save(product);

        // return "Product Added to Database. No, really.";
    }

}
