package com.lavindu.barcelona_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Culer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private Integer phone;
    private Integer age;
    private String country;
    private String password;

}
