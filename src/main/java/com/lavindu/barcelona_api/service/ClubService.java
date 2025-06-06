package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;

import java.io.IOException;
import java.util.List;

public interface ClubService {

    Club create(ClubRequestDTO clubDTO) throws AlreadyExistException, IOException;

    List<Club> findAll();

    Club findById(Long clubId) throws ClubNotFoundException;

    Club updateById(Long clubId, ClubRequestDTO clubDTO) throws ClubNotFoundException, IOException;

    void deleteById(Long clubId);

}
