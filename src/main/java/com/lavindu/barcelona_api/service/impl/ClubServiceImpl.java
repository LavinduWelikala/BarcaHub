package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    @Transactional(rollbackFor = AlreadyExistException.class)
    public Club create(CreateClubDTO clubDTO) throws AlreadyExistException{

       Optional<Club> optionalClub = clubRepository.findByName(clubDTO.getName());

        if (optionalClub.isPresent()) {
            throw new AlreadyExistException("Club already exists");
        }

        else {
            Club club = new Club();

            club.setName(clubDTO.getName());
            club.setMotto(clubDTO.getMotto());
            club.setPresident(clubDTO.getPresident());
            club.setManager(clubDTO.getManager());
            club.setFoundedYear(clubDTO.getFoundedYear());

           return clubRepository.save(club);

        }
    }

    @Override
    public List<Club> getAllClubs() {

        return clubRepository.findAll();
    }

    @Override
    public Club findById(Long clubId) throws ClubNotFoundException {

        Club club = clubRepository.findById(clubId).orElseThrow(
                () -> new ClubNotFoundException("Club ID " + clubId + " Not Found")
        );

        return club;
    }


}

