package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.repository.PlayerRepository;
import com.lavindu.barcelona_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playrepository;

    @Autowired
    private ClubRepository clubRepository;


    @Override
    public void create(CreatePlayerDTO playerDTO) {
        // Find the club by ID from the playerDTO
        Club club = clubRepository.findById(playerDTO.getClubId())
                .orElseThrow(() -> new RuntimeException("Club not found"));

        // Create a new player and populate its fields
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setAge(playerDTO.getAge());
        player.setPosition(playerDTO.getPosition());
        player.setNationality(playerDTO.getNationality());
        player.setJerseyNumber(playerDTO.getJerseyNumber());

        // Associate the player with the club
        player.setClub(club);

        // Save the player directly
        playrepository.save(player);
    }

    @Override
    public void createPlayer(CreatePlayerDTO playerDTO, Long clubId) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found"));

        // Create and set up a new player
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setAge(playerDTO.getAge());
        player.setPosition(playerDTO.getPosition());
        player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setNationality(playerDTO.getNationality());

        // Associate the player with the club
        club.addPlayer(player);

        // Save the club, which also saves the player due to the cascade
        clubRepository.save(club);

    }

















//    List<CreatePlayerDTO> playerList = new ArrayList<>();
//
//    @Override
//    public List<CreatePlayerDTO> getAllPlayers() {
//
//        playerList = playrepo.findAll().stream().map(player -> {
//            CreatePlayerDTO pldto = new CreatePlayerDTO();
//            pldto.setPlayerId(player.getPlayerId());
//            pldto.setName(player.getName());
//            pldto.setAge(player.getAge());
//            pldto.setPosition(player.getPosition());
//            pldto.setJerseyNumber(player.getJerseyNumber());
//            pldto.setNationality(player.getNationality());
//            return pldto;
//        }).collect(Collectors.toList());
//        System.out.println(playerList.size());
//
//        return playerList;
//
//    }

//    @Override
//    public CreatePlayerDTO getPlayerById(Long id) {
//        return null;
//    }
//
//    @Override
//    public CreatePlayerDTO updatePlayer(Long id, CreatePlayerDTO playerDTO) {
//        return null;
//    }
//
//    @Override
//    public void deletePlayer(Long id) {
//
//    }
}