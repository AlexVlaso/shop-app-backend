package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="image_url")
    private String imageUrl;
    @Column(name="quantity")
    private int quantity;
    @Column(name="unit_price")
    private double unitPrice;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

}
