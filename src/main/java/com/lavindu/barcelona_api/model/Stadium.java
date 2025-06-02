package com.lavindu.barcelona_api.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "stadiums")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int capacity;
}
