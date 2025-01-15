package com.lavindu.barcelona_api.controller.request;


import lombok.Data;

@Data
public class CreatePlayerDTO {

        private String name;
        private int age;
        private String position;
        private String nationality;
        private int jerseyNumber;

        private Long clubId;



}
