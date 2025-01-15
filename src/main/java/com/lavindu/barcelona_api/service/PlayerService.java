package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.exception.PlayerAlreadyExistException;
import com.lavindu.barcelona_api.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

     void create(CreatePlayerDTO playerDTO) throws PlayerAlreadyExistException;

     List<Player> getAllPlayers();

}






















//     void createPlayer(CreatePlayerDTO playerDTO, Long clubId);

//      List<CreatePlayerDTO> getAllPlayers();

//    List<CreatePlayerDTO> getAllPlayers();

//    CreatePlayerDTO getPlayerById(Long id);
//    CreatePlayerDTO updatePlayer(Long id, CreatePlayerDTO playerDTO);
//    void deletePlayer(Long id);

