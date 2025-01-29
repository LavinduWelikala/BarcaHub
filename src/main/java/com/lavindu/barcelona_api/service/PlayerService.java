package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.NotFoundException;
import com.lavindu.barcelona_api.exception.PlayerNotFoundException;
import com.lavindu.barcelona_api.model.Player;

import java.util.List;

public interface PlayerService {

     Player create(Long clubId, CreatePlayerDTO playerDTO) throws AlreadyExistException;

     List<Player> findAll();

     List<Player> findAllByClubId(Long clubId) throws NotFoundException;

     Player updateById(Long playerId, CreatePlayerDTO playerDTO) throws PlayerNotFoundException;

}






















//     void createPlayer(CreatePlayerDTO playerDTO, Long clubId);

//      List<CreatePlayerDTO> getAllPlayers();

//    List<CreatePlayerDTO> getAllPlayers();

//    CreatePlayerDTO getPlayerById(Long id);
//    CreatePlayerDTO updatePlayer(Long id, CreatePlayerDTO playerDTO);
//    void deletePlayer(Long id);

