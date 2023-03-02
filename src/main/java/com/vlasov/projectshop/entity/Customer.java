package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name ="email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order> orders;

    public void addOrder(Order order){
        if(orders==null){
            orders=new HashSet<>();
        }
        orders.add(order);
        order.setCustomer(this);
    }
}
