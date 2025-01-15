package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    private LocalDate date;
    private int homeScore;
    private int awayScore;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Club homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Club awayTeam;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

}