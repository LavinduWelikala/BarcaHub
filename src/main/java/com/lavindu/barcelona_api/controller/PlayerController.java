package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.exception.PlayerAlreadyExistException;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/clubs/{club-id}/players")
    public void createClub(@PathVariable ("club-id") Long clubId,
            @RequestBody CreatePlayerDTO playerDto) throws PlayerAlreadyExistException {

        playerService.create(playerDto);
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();

    }

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


