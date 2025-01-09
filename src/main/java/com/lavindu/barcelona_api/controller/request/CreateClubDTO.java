package com.lavindu.barcelona_api.controller.request;

import lombok.Data;

@Data
public class CreateClubDTO {

    private String name;
    private String motto;
    private String president;
    private String manager;
    private int foundedYear;
}
