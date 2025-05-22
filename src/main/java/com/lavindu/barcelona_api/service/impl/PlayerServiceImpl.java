package com.lavindu.barcelona_api.service.impl;

import com.cloudinary.Cloudinary;
import com.lavindu.barcelona_api.controller.request.PlayerRequestDTO;
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
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private Cloudinary cloudinary;
    private PlayerRepository playerRepository;
    private ClubRepository clubRepository;

    @Override
    public Player create(Long clubId, PlayerRequestDTO playerDTO) throws PlayerNotFoundException, AlreadyExistException, IOException {
        Optional<Club> clubOptional = clubRepository.findById(clubId);
        if (clubOptional.isEmpty()) {
            throw new PlayerNotFoundException("Club not found with ID: " + clubId);
        }

        Optional<Player> playerOptional = playerRepository.findByNameAndClubId(playerDTO.getName(), clubId);
        if (playerOptional.isPresent()) {
            throw new AlreadyExistException("Player already exists in this club.");
        }

        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setAge(playerDTO.getAge());
        player.setPosition(playerDTO.getPosition());
        player.setNationality(playerDTO.getNationality());
        player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setClub(clubOptional.get());

        List<String> imageUrls = new ArrayList<>();
        if (playerDTO.getImageFiles() != null) {
            for (MultipartFile file : playerDTO.getImageFiles()) {
                String imageUrl = cloudinary.uploader()
                        .upload(file.getBytes(),
                                Map.of("public_id", UUID.randomUUID().toString()))
                        .get("url")
                        .toString();
                imageUrls.add(imageUrl);
            }
        }
        player.setImageUrl(imageUrls);

        return playerRepository.save(player);
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
    public Player findById(Long playerId) throws PlayerNotFoundException {
        Player player = playerRepository.findById(playerId).orElseThrow(
                () -> new PlayerNotFoundException("Player Id " + playerId + " not found"));

        return player;
    }

    @Override
    public Player updateById(Long playerId, PlayerRequestDTO playerDTO) throws PlayerNotFoundException, IOException {

        Player existingPlayer = playerRepository.findById(playerId).orElseThrow(
                () -> new PlayerNotFoundException("Player ID " + playerId + " Not Found"));

        existingPlayer.setName(playerDTO.getName());
        existingPlayer.setAge(playerDTO.getAge());
        existingPlayer.setPosition(playerDTO.getPosition());
        existingPlayer.setNationality(playerDTO.getNationality());
        existingPlayer.setJerseyNumber(playerDTO.getJerseyNumber());

        List<String> imageUrls = new ArrayList<>();
        if (playerDTO.getImageFiles() != null) {
            for (MultipartFile file : playerDTO.getImageFiles()) {
                String imageUrl = cloudinary.uploader()
                        .upload(file.getBytes(),
                                Map.of("public_id", UUID.randomUUID().toString()))
                        .get("url")
                        .toString();
                imageUrls.add(imageUrl);
            }
        }
        existingPlayer.setImageUrl(imageUrls);

        playerRepository.save(existingPlayer);

        return existingPlayer;
    }

    @Override
    public void deleteById(Long playerId) {

        playerRepository.deleteById(playerId);
    }


}
