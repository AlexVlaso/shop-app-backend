package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="img_url")
    private String imageUrl;
    @Column(name="price")
    private double price;
    @Column(name="quantity")
    private int quantity;
    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name="date_updated")
    @UpdateTimestamp
    private Date dateUpdated;
    @Column(name="active")
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
