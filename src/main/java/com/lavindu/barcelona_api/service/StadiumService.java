package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.StadiumRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;

public interface StadiumService {

    void createStadium(StadiumRequestDTO stadiumDTO) throws AlreadyExistException;
}
