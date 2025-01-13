package com.lavindu.barcelona_api.controller.request;

import lombok.Data;

@Data
public class CreateCulerDTO {

    private String name;
    private String email;
    private Integer phone;
    private Integer age;
    private String country;
    private String password;
}
