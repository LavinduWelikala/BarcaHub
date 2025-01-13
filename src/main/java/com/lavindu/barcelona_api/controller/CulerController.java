package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CreateCulerDTO;
import com.lavindu.barcelona_api.exception.CulerAlreadyExistException;
import com.lavindu.barcelona_api.service.CulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CulerController {

    @Autowired
    private CulerService culerService;

    @PostMapping("/culers")
    public void registerUser(@RequestBody CreateCulerDTO culerDTO) throws CulerAlreadyExistException {

        culerService.createCuler(culerDTO);
    }
}
