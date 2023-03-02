package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;
    @Column(name="state")
    private String state;
    @Column(name="address")
    private String address;
    @Column(name="zip_code")
    private int zipCode;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;

}
