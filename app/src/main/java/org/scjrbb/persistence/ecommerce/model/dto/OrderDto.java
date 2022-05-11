package org.scjrbb.persistence.ecommerce.model.dto;

import java.util.List;

public class OrderDto {
    private String clientID;
    private Integer adressId;
    private List<OrderProductDto> orderItens;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public List<OrderProductDto> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<OrderProductDto> orderItens) {
        this.orderItens = orderItens;
    }
}
