package com.vlasov.projectshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "country_id")
    private Set<State> states;
}
