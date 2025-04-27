package com.lavindu.barcelona_api.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubResponse {

    private Long id;
    private String name;
    private String motto;
    private String president;
    private String manager;
    private int foundedYear;
}
