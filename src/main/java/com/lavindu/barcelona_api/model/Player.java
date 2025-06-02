package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String position;
    private String nationality;
    private int jerseyNumber;

    @Enumerated(EnumType.STRING)
    private Status playerStatus;


    @ElementCollection
    private List<String> imageUrl;


    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

}
