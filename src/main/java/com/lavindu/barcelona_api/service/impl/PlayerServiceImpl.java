package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.repository.PlayerRepository;
import com.lavindu.barcelona_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playrepo;


    @Override
    public void create(CreatePlayerDTO pldto) {

        Player player = new Player();

        player.setName(pldto.getName());
        player.setAge(pldto.getAge());
        player.setPosition(pldto.getPosition());
        player.setNationality(pldto.getNationality());
        player.setJerseyNumber(pldto.getJerseyNumber());

        playrepo.save(player);







    }
}
