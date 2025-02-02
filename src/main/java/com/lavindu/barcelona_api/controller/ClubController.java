package com.lavindu.barcelona_api.controller;


import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.controller.response.ClubResponse;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("/clubs")
    public ClubResponse create(@RequestBody CreateClubDTO dto) throws AlreadyExistException {
        Club club = clubService.create(dto);

        ClubResponse response = new ClubResponse();

        response.setClubId(club.getId());
        response.setName(club.getName());
        response.setMotto(club.getMotto());
        response.setPresident(club.getPresident());
        response.setManager(club.getManager());
        response.setFoundedYear(club.getFoundedYear());

        return response;
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

    @GetMapping("/clubs/{club-id}")
    public ClubResponse findById(@PathVariable("club-id") Long clubId) throws ClubNotFoundException {

        Club club = clubService.findById(clubId);

        ClubResponse response = new ClubResponse();

        response.setClubId(club.getId());
        response.setName(club.getName());
        response.setMotto(club.getMotto());
        response.setPresident(club.getPresident());
        response.setManager(club.getManager());
        response.setFoundedYear(club.getFoundedYear());

        return response;
    }
}
