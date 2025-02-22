package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.StadiumRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.service.StadiumService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StadiumController {

    private StadiumService stadiumService;

    @PostMapping("/stadiums")
    public void create(@RequestBody StadiumRequestDTO stadiumDTO) throws AlreadyExistException {

        stadiumService.createStadium(stadiumDTO);

    }
}
