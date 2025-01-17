package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreateStadiumDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Stadium;
import com.lavindu.barcelona_api.repository.StadiumRepository;
import com.lavindu.barcelona_api.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StadiumServiceImpl implements StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    @Transactional(rollbackFor = AlreadyExistException.class)
    @Override
    public void createStadium(CreateStadiumDTO stadiumDTO) throws AlreadyExistException {

        Optional<Stadium> stadiumOptional = stadiumRepository.findByName(stadiumDTO.getName());

        if (stadiumOptional.isPresent()) {
            throw new AlreadyExistException("Stadium already exists");
        }
        else {

            Stadium stadium = new Stadium();

            stadium.setName(stadiumDTO.getName());
            stadium.setLocation(stadiumDTO.getLocation());
            stadium.setCapacity(stadiumDTO.getCapacity());

            stadiumRepository.save(stadium);
        }

    }
}
