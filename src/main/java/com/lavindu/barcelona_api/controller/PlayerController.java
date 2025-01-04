package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/players")
    public void createClub(@RequestBody CreatePlayerDTO dto){
        playerService.create(dto);
    }

    @GetMapping("/players")
    public List<CreatePlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

}
