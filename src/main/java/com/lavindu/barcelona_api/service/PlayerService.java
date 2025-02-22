package com.lavindu.barcelona_api.service;

import com.lavindu.barcelona_api.controller.request.PlayerRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.NotFoundException;
import com.lavindu.barcelona_api.exception.PlayerNotFoundException;
import com.lavindu.barcelona_api.model.Player;

import java.util.List;

public interface PlayerService {

     Player create(Long clubId, PlayerRequestDTO playerDTO) throws PlayerNotFoundException, AlreadyExistException;

     List<Player> findAll();

     List<Player> findAllByClubId(Long clubId) throws NotFoundException;

     Player findById(Long playerId) throws PlayerNotFoundException;

     Player updateById(Long playerId, PlayerRequestDTO playerDTO) throws PlayerNotFoundException;

     void deleteById(Long playerId);

}






















//     void createPlayer(CreatePlayerDTO playerDTO, Long clubId);

//      List<CreatePlayerDTO> getAllPlayers();

//    List<CreatePlayerDTO> getAllPlayers();

//    CreatePlayerDTO getPlayerById(Long id);
//    CreatePlayerDTO updatePlayer(Long id, CreatePlayerDTO playerDTO);
//    void deletePlayer(Long id);

