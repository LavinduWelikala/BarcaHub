package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreateCulerDTO;
import com.lavindu.barcelona_api.exception.CulerAlreadyExistException;
import com.lavindu.barcelona_api.model.Culer;
import com.lavindu.barcelona_api.repository.CulerRepository;
import com.lavindu.barcelona_api.service.CulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CulerServiceImpl implements CulerService {

    @Autowired
    private CulerRepository culerRepository;

    @Override
    public void createCuler(CreateCulerDTO culerDTO) throws CulerAlreadyExistException {

        Optional<Culer> culerOptional = culerRepository.findByName(culerDTO.getName());

        if (culerOptional.isPresent()) {
            throw new CulerAlreadyExistException("Culer already exists");
        }

        else{

            Culer culer = new Culer();

            culer.setName(culerDTO.getName());
            culer.setEmail(culerDTO.getEmail());
            culer.setPhone(culerDTO.getPhone());
            culer.setAge(culerDTO.getAge());
            culer.setCountry(culerDTO.getCountry());
            culer.setPassword(culerDTO.getPassword());

            culerRepository.save(culer);
        }

    }
}
