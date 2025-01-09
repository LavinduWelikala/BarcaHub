package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreatePlayerDTO;
import com.lavindu.barcelona_api.model.Player;
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
