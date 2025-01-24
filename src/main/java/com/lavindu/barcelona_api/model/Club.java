package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "clubs")
public class Club {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String name;
        private String motto;
        private String president;
        private String manager;
        private int foundedYear;

        @OneToMany(mappedBy = "club")
        private List<Player> playerList;

}
