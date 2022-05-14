package org.scjrbb.persistence.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.scjrbb.persistence.ecommerce.model.Address;
import org.scjrbb.persistence.ecommerce.model.Customer;
import org.scjrbb.persistence.ecommerce.model.Order;
import org.scjrbb.persistence.ecommerce.model.OrderCustomer;
import org.scjrbb.persistence.ecommerce.model.OrderProduct;
import org.scjrbb.persistence.ecommerce.model.Product;
import org.scjrbb.persistence.ecommerce.model.dto.OrderDto;
import org.scjrbb.persistence.ecommerce.model.dto.OrderProductDto;
import org.scjrbb.persistence.ecommerce.repository.CustomerRepository;
import org.scjrbb.persistence.ecommerce.repository.OrderRepository;
import org.scjrbb.persistence.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/order")
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> findOrderById(@PathVariable String id) {
        return orderRepository.findById(id);
    }

    // Inserção de uma venda
    @PostMapping("/order")
    public Order addOrder(@RequestBody OrderDto orderDto) {

        // Recebo uma dto da ordem e tenho que transformar num objeto ordem;
        Order order = new Order();

        order.setId(orderDto.getId().toString());

        Optional<Customer> customer = customerRepository.findById(orderDto.getClientID());
        if (customer != null) {
            OrderCustomer orderCustomer = new OrderCustomer(customer.get());
            order.setOrderCustomer(orderCustomer);

            List<Address> enderecos = customer.get().getAddress();
            for (Address ad : enderecos) {
                if (ad.getId() == orderDto.getAdressId()) {
                    order.setDeliveryAddress(ad);
                    break;
                }
            }

        } else {
            throw new Error("Não foi possivel adicionar a venda cliente inexitente");
        }

        order.setTotalValue(0.00);

        ArrayList<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        // Adicionando os produtos a venda
        for (OrderProductDto orderItem : orderDto.getOrderItens()) {

            OrderProduct orderProd = new OrderProduct();

            Optional<Product> prodNoBanco = productRepository.findById(orderItem.getProductId().toString());
            if (prodNoBanco != null) {

                if (prodNoBanco.get().getStock() >= orderItem.getAmount()) {

                    Product prodAtualizar = prodNoBanco.get();
                    prodAtualizar.setStock(prodAtualizar.getStock() - orderItem.getAmount());
                    productRepository.save(prodAtualizar);

                    orderProd.setProduct(prodNoBanco.get().getName());
                    orderProd.setAmount(orderItem.getAmount());
                    orderProd.setUnitValue(prodNoBanco.get().getPrice());
                    orderProd.setValue(orderProd.getUnitValue() * orderProd.getAmount());

                    orderProducts.add(orderProd);

                    order.setTotalValue(order.getTotalValue() + orderProd.getValue());

                } else {
                    throw new Error("Quantidade em estoque menor que a quantidade da venda");
                }

            } else {
                throw new Error("Não foi possivel adicionar o produto a venda produto inexistente");
            }
        }

        order.setProducts(orderProducts);
        order.setDate();

        orderRepository.save(order);

        return order;
    }

}
