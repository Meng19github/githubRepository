package com.example.demolastss.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PropertyName;
    private String BrandName;
    private String PurchasePrice;
    private String StoreKeeperName;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

}

