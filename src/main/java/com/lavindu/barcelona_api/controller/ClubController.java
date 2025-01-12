package com.lavindu.barcelona_api.controller;


import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.exception.ClubAlreadyExistException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("/clubs")
    public void create(@RequestBody CreateClubDTO dto) throws ClubAlreadyExistException {
        clubService.createPlayer(dto);
    }

    @GetMapping("/clubs")
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

}
