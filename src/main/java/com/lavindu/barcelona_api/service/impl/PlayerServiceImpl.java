package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.NotFoundException;
import com.lavindu.barcelona_api.exception.PlayerNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.repository.PlayerRepository;
import com.lavindu.barcelona_api.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private ClubRepository clubRepository;

    @Override
    public Player create(Long clubId, CreatePlayerDTO playerDTO) throws AlreadyExistException {

        Optional<Player> playerOptional = playerRepository.findByName(playerDTO.getName());

        if (playerOptional.isPresent()) {
            throw new AlreadyExistException("Player already exists");
        }

        else{

            Player player = new Player();

            Club club = new Club();

            club.setId(clubId);

            player.setName(playerDTO.getName());
            player.setAge(playerDTO.getAge());
            player.setPosition(playerDTO.getPosition());
            player.setNationality(playerDTO.getNationality());
            player.setJerseyNumber(playerDTO.getJerseyNumber());

            player.setClub(club);
            
            return playerRepository.save(player);

        }
    }

    @Override
    public List<Player> findAll() {

        return playerRepository.findAll();
    }

    @Override
    public List<Player> findAllByClubId(Long clubId) throws NotFoundException {

        Club club = clubRepository.findById(clubId).orElseThrow(
                () -> new NotFoundException("Club ID " + clubId + " Not Found"));

        List<Player> players = playerRepository.findByClub(club);

        return players;
    }

    @Override
    public Player updateById(Long playerId, CreatePlayerDTO playerDTO) throws PlayerNotFoundException {

        Player existingPlayer = playerRepository.findById(playerId).orElseThrow(
                () -> new PlayerNotFoundException("Player ID " + playerId + " Not Found"));

        existingPlayer.setName(playerDTO.getName());
        existingPlayer.setAge(playerDTO.getAge());
        existingPlayer.setPosition(playerDTO.getPosition());
        existingPlayer.setNationality(playerDTO.getNationality());
        existingPlayer.setJerseyNumber(playerDTO.getJerseyNumber());

        playerRepository.save(existingPlayer);

        return existingPlayer;
    }


}
