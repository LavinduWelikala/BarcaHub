package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    private String playerName;
    private int age;
    private int height;
    private String position;
    private int jercyNumber;
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}
