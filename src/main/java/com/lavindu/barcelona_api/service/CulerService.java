package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreateCulerDTO;
import com.lavindu.barcelona_api.exception.CulerAlreadyExistException;

public interface CulerService {

    void createCuler(CreateCulerDTO culerDTO) throws CulerAlreadyExistException;
}
