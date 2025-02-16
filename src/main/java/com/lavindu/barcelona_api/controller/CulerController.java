package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CreateCulerDTO;
import com.lavindu.barcelona_api.controller.response.CulerResponse;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Culer;
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
    public CulerResponse registerUser(@RequestBody CreateCulerDTO culerDTO) throws AlreadyExistException {

       Culer culer =  culerService.create(culerDTO);

       CulerResponse culerResponse = new CulerResponse();

       culerResponse.setName(culer.getName());
       culerResponse.setAge(culer.getAge());
       culerResponse.setPhone(culer.getPhone());
       culerResponse.setEmail(culer.getEmail());
       culerResponse.setCountry(culer.getCountry());
       culerResponse.setPassword(culer.getPassword());
       culerResponse.setCulerId(culer.getId());

       return culerResponse;
    }
}
