package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.StadiumRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Stadium;
import com.lavindu.barcelona_api.repository.StadiumRepository;
import com.lavindu.barcelona_api.service.StadiumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StadiumServiceImpl implements StadiumService {

    private StadiumRepository stadiumRepository;

    @Override
    public void createStadium(StadiumRequestDTO stadiumDTO) throws AlreadyExistException {

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
