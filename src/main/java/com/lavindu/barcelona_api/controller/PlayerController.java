package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
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

@AllArgsConstructor
@RestController
public class PlayerController {

    private PlayerService playerService;

    @PostMapping("/clubs/{club-id}/players")
    public PlayerResponse createClub(@PathVariable ("club-id") Long clubId,
            @RequestBody CreatePlayerDTO playerDto) throws AlreadyExistException {

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
    public List<PlayerResponse> getAllPlayers() {

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
    public List<PlayerResponse> getPlayersById(@PathVariable("club-id") Long clubId ) throws NotFoundException {

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

    @PutMapping("/players/{player-id}")
    public PlayerResponse updatePlayer(@RequestBody CreatePlayerDTO playerDTO,
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
}


