package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String email;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    public Customer(String customerName, String email, String address, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        orders.add(order);
    }
}
