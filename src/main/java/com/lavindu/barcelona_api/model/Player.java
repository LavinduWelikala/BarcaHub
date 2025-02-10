package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String position;
    private String nationality;
    private int jerseyNumber;


    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

}
