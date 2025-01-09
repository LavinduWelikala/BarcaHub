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
    private Integer age;
    private String position;
    private Integer jerseyNumber;
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

}
