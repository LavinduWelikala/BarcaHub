package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CulerRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Culer;

public interface CulerService {

    Culer create(CulerRequestDTO culerDTO) throws AlreadyExistException;


}
