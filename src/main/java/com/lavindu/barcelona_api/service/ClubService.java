package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.exception.ClubAlreadyExistException;

public interface ClubService {

    void createPlayer(CreateClubDTO clubDTO) throws ClubAlreadyExistException;
}
