package com.lavindu.barcelona_api.controller.response;


import lombok.Data;


import java.util.List;

@Data
public class ClubResponse {

    private Long id;
    private String name;
    private String motto;
    private String president;
    private String manager;
    private int foundedYear;
    private List<String> imageFiles;
}
