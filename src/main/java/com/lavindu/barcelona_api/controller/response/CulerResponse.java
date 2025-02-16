package com.lavindu.barcelona_api.controller.response;

import lombok.Data;

@Data
public class CulerResponse {

    private String name;
    private String email;
    private Integer phone;
    private Integer age;
    private String country;
    private String password;
    private Long culerId;
}
