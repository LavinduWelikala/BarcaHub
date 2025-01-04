package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    private String name;
    private int age;
    private String position;
    private int jerseyNumber;
    private String nationality;

//    @ManyToOne
//    @JoinColumn(name = "club_id")
//    private Club club;

}
