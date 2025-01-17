package com.lavindu.barcelona_api.controller.response;

import lombok.Data;

@Data
public class ClubResponse {

    private Long clubId;
    private String name;
    private String motto;
    private String president;
    private String manager;
    private int foundedYear;
}
