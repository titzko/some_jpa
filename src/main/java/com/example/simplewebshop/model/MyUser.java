package com.example.simplewebshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Basket basket;

    public MyUser(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
