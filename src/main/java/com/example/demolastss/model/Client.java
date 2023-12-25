package com.example.demolastss.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ClientName;

    private String Department;
    private String PhoneNumber;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    List<Properties> properties;



}





