package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Club;

import java.util.List;

public interface ClubService {

    void createPlayer(CreateClubDTO clubDTO) throws AlreadyExistException;

    List<Club> getAllClubs();

}
