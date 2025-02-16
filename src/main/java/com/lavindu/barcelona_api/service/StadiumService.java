package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreateStadiumDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;

public interface StadiumService {

    void createStadium(CreateStadiumDTO stadiumDTO) throws AlreadyExistException;
}
