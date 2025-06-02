package com.lavindu.barcelona_api.controller.response;

import com.lavindu.barcelona_api.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class PlayerResponse {

    private Long id;
    private String name;
    private int age;
    private String position;
    private String nationality;
    private int jerseyNumber;

    @Enumerated(EnumType.STRING)
    private Status playerStatus;

    private List<String> imageFiles;
    private Long clubId;
}
