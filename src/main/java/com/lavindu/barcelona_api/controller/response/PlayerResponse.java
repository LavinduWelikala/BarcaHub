package com.lavindu.barcelona_api.controller.response;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PlayerResponse {

    private Long id;
    private String name;
    private int age;
    private String position;
    private String nationality;
    private int jerseyNumber;

    private List<String> imageFiles;


    private Long clubId;
}
