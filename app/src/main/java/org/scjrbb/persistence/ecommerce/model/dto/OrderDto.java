package org.scjrbb.persistence.ecommerce.model.dto;

import java.util.List;

import org.scjrbb.persistence.ecommerce.model.Address;

public class OrderDto {
    private String clientID;
    private Address deliveryAddress;
    private List<Object> orderItens;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Object> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<Object> orderItens) {
        this.orderItens = orderItens;
    }
}
