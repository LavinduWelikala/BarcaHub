package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "clubs")
public class Club {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String motto;
        private String president;
        private String manager;
        private int foundedYear;

        @ElementCollection
        private List<String> imageUrl;

        @OneToMany(mappedBy = "club")
        private List<Player> playerList;

}
