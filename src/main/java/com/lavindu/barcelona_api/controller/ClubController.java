package com.lavindu.barcelona_api.controller;


import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.controller.response.ClubResponse;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("/clubs")
    public void create(@RequestBody CreateClubDTO dto) throws AlreadyExistException {
        clubService.createPlayer(dto);
    }

    @GetMapping("/clubs")
    public List<ClubResponse> getAllClubs(Long clubId) {

        List<Club> clubs = clubService.getAllClubs();

        List<ClubResponse> clubResponses = new ArrayList<>();

        for (Club club : clubs) {

            ClubResponse response = new ClubResponse();
            response.setClubId(club.getId());

            response.setName(club.getName());
            response.setMotto(club.getMotto());
            response.setPresident(club.getPresident());
            response.setManager(club.getManager());
            response.setFoundedYear(club.getFoundedYear());


            clubResponses.add(response);
        }
        return clubResponses;
    }

}
