package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CreateStadiumDTO;
import com.lavindu.barcelona_api.exception.StadiumAlreadyExistException;
import com.lavindu.barcelona_api.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @PostMapping("/stadiums")
    public void create(@RequestBody CreateStadiumDTO stadiumDTO) throws StadiumAlreadyExistException {

        stadiumService.createStadium(stadiumDTO);

    }
}
