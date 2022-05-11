package org.scjrbb.persistence.ecommerce.model;

public class OrderCustomer {
    private String name;
    private String phone;
    private String mail;
    private Address billingAddress;

    public OrderCustomer() {
    }

    public OrderCustomer(Customer customer) {
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.mail = customer.getEmail();
        this.billingAddress = customer.getAddress().get(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

}
