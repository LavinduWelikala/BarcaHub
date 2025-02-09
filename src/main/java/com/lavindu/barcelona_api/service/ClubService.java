package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;

import java.util.List;

public interface ClubService {

    Club create(CreateClubDTO clubDTO) throws AlreadyExistException;

    List<Club> getAllClubs();

    Club findById(Long clubId) throws ClubNotFoundException;

    Club updateById(Long clubId, CreateClubDTO clubDTO) throws ClubNotFoundException;

    void deleteById(Long clubId);

}
