package com.lavindu.barcelona_api.controller.request;

import com.lavindu.barcelona_api.model.Club;
import lombok.Data;

@Data
public class CreatePlayerDTO {

        private String name;
        private int age;
        private String position;
        private String nationality;
        private int jerseyNumber;



}
