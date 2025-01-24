package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.NotFoundException;
import com.lavindu.barcelona_api.exception.PlayerNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.repository.ClubRepo;
import com.lavindu.barcelona_api.repository.PlayerRepository;
import com.lavindu.barcelona_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubRepo clubRepo;

    @Transactional(rollbackFor = AlreadyExistException.class)
    @Override
    public void create(Long clubId, CreatePlayerDTO playerDTO) throws AlreadyExistException {

        Optional<Player> playerOptional = playerRepository.findByName(playerDTO.getName());

        if (playerOptional.isPresent()) {
            throw new AlreadyExistException("Player already exists");
        }

        else{

            Player player = new Player();

            Club club = new Club();

            club.setId(playerDTO.getClubId());

            player.setName(playerDTO.getName());
            player.setAge(playerDTO.getAge());
            player.setPosition(playerDTO.getPosition());
            player.setNationality(playerDTO.getNationality());
            player.setJerseyNumber(playerDTO.getJerseyNumber());

            player.setClub(club);
            
            playerRepository.save(player);

        }
    }

    @Override
    public List<Player> getAllPlayers() {

        return playerRepository.findAll();
    }

    @Override
    public List<Player> getAllPlayersByClubId(Long clubId) throws NotFoundException {

        Club club = clubRepo.findById(clubId).orElseThrow(
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






























//    @Autowired
//    private ClubRepository clubRepository;
//
//
//    @Override
//    public void create(CreatePlayerDTO playerDTO) {
//        // Find the club by ID from the playerDTO
//        Club club = clubRepository.findById(playerDTO.getClubId())
//                .orElseThrow(() -> new RuntimeException("Club not found"));
//
//        // Create a new player and populate its fields
//        Player player = new Player();
//        player.setName(playerDTO.getName());
//        player.setAge(playerDTO.getAge());
//        player.setPosition(playerDTO.getPosition());
//        player.setNationality(playerDTO.getNationality());
//        player.setJerseyNumber(playerDTO.getJerseyNumber());
//
//        // Associate the player with the club
//        player.setClub(club);
//
//        // Save the player directly
//        playrepository.save(player);
//    }
//
//    @Override
//    public void createPlayer(CreatePlayerDTO playerDTO, Long clubId) {
//        Club club = clubRepository.findById(clubId)
//                .orElseThrow(() -> new RuntimeException("Club not found"));
//
//        // Create and set up a new player
//        Player player = new Player();
//        player.setName(playerDTO.getName());
//        player.setAge(playerDTO.getAge());
//        player.setPosition(playerDTO.getPosition());
//        player.setJerseyNumber(playerDTO.getJerseyNumber());
//        player.setNationality(playerDTO.getNationality());
//
//        // Associate the player with the club
//        club.addPlayer(player);
//
//        // Save the club, which also saves the player due to the cascade
//        clubRepository.save(club);
//
//    }

//    @Override
//    public List<CreatePlayerDTO> getAllPlayers() {
//        List<Player> players = playrepository.findAll();
//        return players.stream().map(player -> {
//            CreatePlayerDTO dto = new CreatePlayerDTO();
//            dto.setName(player.getName());
//            dto.setAge(player.getAge());
//            dto.setPosition(player.getPosition());
//            dto.setNationality(player.getNationality());
//            dto.setJerseyNumber(player.getJerseyNumber());
//            return dto;
//        }).collect(Collectors.toList());
//    }
















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

