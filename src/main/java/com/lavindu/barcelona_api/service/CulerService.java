package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreateCulerDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Culer;

public interface CulerService {

    Culer create(CreateCulerDTO culerDTO) throws AlreadyExistException;


}
