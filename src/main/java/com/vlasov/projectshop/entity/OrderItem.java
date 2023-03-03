package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_item")
@Getter
@Setter
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
    @Column(name="product_id")
    private int productId;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

}
