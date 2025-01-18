package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.controller.response.ClubResponse;
import com.lavindu.barcelona_api.controller.response.PlayerResponse;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.NotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/clubs/{club-id}/players")
    public void createClub(@PathVariable ("club-id") Long clubId,
            @RequestBody CreatePlayerDTO playerDto) throws AlreadyExistException {

        playerService.create(playerDto);
    }

    @GetMapping("/players")
    public List<PlayerResponse> getAllPlayers() {

        List<Player> playerList = playerService.getAllPlayers();

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


//    @GetMapping("/clubs/{club-id}/players")
//    public List<PlayerResponse> getPlayersById(@PathVariable("club-id") Long clubId ) throws NotFoundException {
//
//        List<Player> playerList = playerService.getAllPlayersByClubId(clubId);
//
//        List<PlayerResponse> playerResponseList = new ArrayList<>();
//
//        for (Player player : playerList) {
//            PlayerResponse response = new PlayerResponse();
//
//            response.setId(player.getId());
//            response.setName(player.getName());
//            response.setAge(player.getAge());
//            response.setNationality(player.getNationality());
//            response.setPosition(player.getPosition());
//            response.setJerseyNumber(player.getJerseyNumber());
//            response.setClubId(player.getClub().getId());
//
//            playerResponseList.add(response);
//        }
//        return playerResponseList;
//    }

}




















//    @GetMapping("/players")
//    public List<CreatePlayerDTO> getAllPlayers() {
//        return playerService.getAllPlayers();
//    }

    //    @PostMapping
//    public ResponseEntity<String> createPlayer(@Valid @RequestBody CreatePlayerDTO dto) {
//        try {
//            playerService.create(dto);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Player created successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}

    //@RestController
//public class PlayerController {
//
//    @Autowired
//    private PlayerService playerService;
//


