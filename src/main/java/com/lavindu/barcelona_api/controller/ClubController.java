package com.lavindu.barcelona_api.controller;


import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
import com.lavindu.barcelona_api.controller.response.ClubResponse;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.service.ClubService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ClubController {

    private ClubService clubService;

    @PostMapping("/clubs")
    public ClubResponse create(
            @ModelAttribute ClubRequestDTO clubDTO) throws AlreadyExistException, IOException {

//        return clubService.create(clubDTO);
        Club club = clubService.create(clubDTO);

        ClubResponse response = new ClubResponse();

        response.setId(club.getId());
        response.setName(club.getName());
        response.setMotto(club.getMotto());
        response.setPresident(club.getPresident());
        response.setManager(club.getManager());
        response.setFoundedYear(club.getFoundedYear());
        response.setImageFiles(club.getImageUrl());

        return response;
    }

    @GetMapping(value = "/clubs")
    public List<ClubResponse> getAllClubs() {

        List<Club> clubs = clubService.findAll();

        List<ClubResponse> clubResponseList = new ArrayList<>();

        for (Club club : clubs) {
            ClubResponse response = new ClubResponse();

            response.setId(club.getId());
            response.setName(club.getName());
            response.setMotto(club.getMotto());
            response.setPresident(club.getPresident());
            response.setManager(club.getManager());
            response.setFoundedYear(club.getFoundedYear());
            response.setImageFiles(club.getImageUrl());

            clubResponseList.add(response);
        }
        return clubResponseList;




    }


    @GetMapping("/clubs/{club-id}")
    public ClubResponse getById(@PathVariable("club-id") Long clubId) throws ClubNotFoundException {

        Club club = clubService.findById(clubId);

        ClubResponse response = new ClubResponse();

        response.setId(club.getId());
        response.setName(club.getName());
        response.setMotto(club.getMotto());
        response.setPresident(club.getPresident());
        response.setManager(club.getManager());
        response.setFoundedYear(club.getFoundedYear());

        return response;
    }

//    @PutMapping("/clubs/{club-id}")
//    public ClubResponse updateById(@PathVariable("club-id") Long clubId,
//                                   @RequestBody ClubRequestDTO clubDTO) throws ClubNotFoundException {
//
//        Club updatedClub = clubService.updateById(clubId,clubDTO);
//
//        ClubResponse response = new ClubResponse();
//
//        response.setId(updatedClub.getId());
//        response.setName(updatedClub.getName());
//        response.setMotto(updatedClub.getMotto());
//        response.setPresident(updatedClub.getPresident());
//        response.setManager(updatedClub.getManager());
//        response.setFoundedYear(updatedClub.getFoundedYear());
//
//        return response;
//    }

    @DeleteMapping("/clubs/{club-id}")
    public void deleteById(@PathVariable("club-id") Long clubId){

        clubService.deleteById(clubId);
    }
}
