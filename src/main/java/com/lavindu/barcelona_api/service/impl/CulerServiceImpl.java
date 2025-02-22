package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CulerRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Culer;
import com.lavindu.barcelona_api.repository.CulerRepository;
import com.lavindu.barcelona_api.service.CulerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CulerServiceImpl implements CulerService {

    private CulerRepository culerRepository;

    @Override
    public Culer create(CulerRequestDTO culerDTO) throws AlreadyExistException {

        Optional<Culer> culerOptional = culerRepository.findByName(culerDTO.getName());

        if (culerOptional.isPresent()) {
            throw new AlreadyExistException("Culer already exists");}

            Culer culer = new Culer();

            culer.setName(culerDTO.getName());
            culer.setEmail(culerDTO.getEmail());
            culer.setPhone(culerDTO.getPhone());
            culer.setAge(culerDTO.getAge());
            culer.setCountry(culerDTO.getCountry());
            culer.setPassword(culerDTO.getPassword());

            return culerRepository.save(culer);
    }
}
