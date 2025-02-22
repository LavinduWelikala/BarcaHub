package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.PlayerRequestDTO;
import com.lavindu.barcelona_api.controller.response.PlayerResponse;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.NotFoundException;
import com.lavindu.barcelona_api.exception.PlayerNotFoundException;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @PostMapping("/clubs/{club-id}/players")
    public PlayerResponse create(@PathVariable("club-id") Long clubId, @RequestBody PlayerRequestDTO playerDto) throws AlreadyExistException, PlayerNotFoundException {
        Player player = playerService.create(clubId, playerDto);
        PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setAge(player.getAge());
        response.setNationality(player.getNationality());
        response.setPosition(player.getPosition());
        response.setJerseyNumber(player.getJerseyNumber());
        response.setClubId(player.getClub().getId());
        return response;
    }



    @GetMapping("/players")
    public List<PlayerResponse> getAll() {

        List<Player> playerList = playerService.findAll();

        List<PlayerResponse> playerResponses = new ArrayList<>();

        for (Player player : playerList) {

            PlayerResponse response = new PlayerResponse();
            response.setId(player.getId());
            response.setClubId(player.getClub().getId());

            response.setName(player.getName());
            response.setAge(player.getAge());
            response.setNationality(player.getNationality());
            response.setPosition(player.getPosition());
            response.setJerseyNumber(player.getJerseyNumber());
            response.setClubId(player.getClub().getId());

            playerResponses.add(response);
        }
        return playerResponses;
    }


    @GetMapping("/clubs/{club-id}/players")
    public List<PlayerResponse> getAllByClubId(@PathVariable("club-id") Long clubId ) throws NotFoundException {

        List<Player> playerList = playerService.findAllByClubId(clubId);

        List<PlayerResponse> playerResponseList = new ArrayList<>();

        for (Player player : playerList) {
            PlayerResponse response = new PlayerResponse();

            response.setId(player.getId());
            response.setName(player.getName());
            response.setAge(player.getAge());
            response.setNationality(player.getNationality());
            response.setPosition(player.getPosition());
            response.setJerseyNumber(player.getJerseyNumber());
            response.setClubId(player.getClub().getId());

            playerResponseList.add(response);
        }
        return playerResponseList;
    }

    @GetMapping("/players/{player-id}")
    public PlayerResponse getById(@PathVariable ("player-id") Long playerId) throws PlayerNotFoundException {

        Player getPlayer = playerService.findById(playerId);

        PlayerResponse response = new PlayerResponse();

        response.setId(getPlayer.getId());
        response.setName(getPlayer.getName());
        response.setAge(getPlayer.getAge());
        response.setNationality(getPlayer.getNationality());
        response.setPosition(getPlayer.getPosition());
        response.setJerseyNumber(getPlayer.getJerseyNumber());
        response.setClubId(getPlayer.getClub().getId());

        return response;
    }

    @PutMapping("/players/{player-id}")
    public PlayerResponse updateById(@RequestBody PlayerRequestDTO playerDTO,
                             @PathVariable ("player-id") Long playerId) throws PlayerNotFoundException {

        Player player = playerService.updateById(playerId,playerDTO);

        PlayerResponse response = new PlayerResponse();

        response.setId(player.getId());
        response.setName(player.getName());
        response.setAge(player.getAge());
        response.setNationality(player.getNationality());
        response.setPosition(player.getPosition());
        response.setJerseyNumber(player.getJerseyNumber());
        response.setClubId(player.getClub().getId());

        return response;
    }
    @DeleteMapping("/players/{player-id}")
    public void deleteById(@PathVariable("player-id") Long playerId){

        playerService.deleteById(playerId);
    }
}


