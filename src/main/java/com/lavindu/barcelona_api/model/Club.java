package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "clubs")
public class Club {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long clubId;

        private String name;
        private String motto;
        private String president;
        private String manager;
        private int foundedYear;

        @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Player> players = new ArrayList<>();

        public void addPlayer(Player player) {
                players.add(player);
                player.setClub(this);
        }

        public void removePlayer(Player player) {
                players.remove(player);
                player.setClub(null);
        }



}
