package com.lavindu.barcelona_api.controller.request;

import lombok.Data;

@Data
public class CreateStadiumDTO {

    private String name;
    private String location;
    private int capacity;
}
