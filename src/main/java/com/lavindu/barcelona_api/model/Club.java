package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clubs")
public class Club {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long clubId;

        private String name;
        private String crest;
        private String motto;
        private String anthem;
        private String president;
        private String manager;
        private int foundedYear;

}