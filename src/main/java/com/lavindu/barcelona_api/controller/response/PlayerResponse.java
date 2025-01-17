package com.lavindu.barcelona_api.controller.response;

import lombok.Data;

@Data
public class PlayerResponse {

    private Long id;
    private String name;
    private int age;
    private String position;
    private String nationality;
    private int jerseyNumber;

    private Long clubId;
}
