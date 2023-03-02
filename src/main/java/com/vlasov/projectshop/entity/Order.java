package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="orders")
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
    @OneToOne
    @JoinColumn(name="shipping_address_id")
    private Address address;
    @Column(name="status")
    private String status;
    @Column(name="date_created")
    private Date dateCreated;
    @Column(name="date_updated")
    @UpdateTimestamp
    private Date dateUpdated;
}
