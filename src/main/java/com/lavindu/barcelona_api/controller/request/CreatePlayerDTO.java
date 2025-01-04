package com.lavindu.barcelona_api.controller.request;

import lombok.Data;

@Data
public class CreatePlayerDTO {


        private Long playerId;
        private String name;
        private String position;
        private int age;
        private int jerseyNumber;
        private String nationality;



}
