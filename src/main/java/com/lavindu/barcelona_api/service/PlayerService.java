package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;

import java.util.List;

public interface PlayerService {

     void create(CreatePlayerDTO pldto);

     void createPlayer(CreatePlayerDTO playerDTO, Long clubId);

//    List<CreatePlayerDTO> getAllPlayers();

//    CreatePlayerDTO getPlayerById(Long id);
//    CreatePlayerDTO updatePlayer(Long id, CreatePlayerDTO playerDTO);
//    void deletePlayer(Long id);

}
