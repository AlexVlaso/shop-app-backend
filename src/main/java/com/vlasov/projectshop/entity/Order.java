package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="order_tracking_number")
    private String orderTrackingNumber;
    @Column(name="totalPrice")
    private double totalPrice;
    @Column(name="total_quantity")
    private int totalQuantity;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id")
    private Address address;
    @Column(name="status")
    private String status;
    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date dateUpdated;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<OrderItem> orderItems;

    public void add(OrderItem orderItem){
        if(orderItems ==null){
            orderItems=new ArrayList<>();

        }
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
