package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.CreateClubDTO;
import com.lavindu.barcelona_api.exception.ClubAlreadyExistException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    @Transactional(rollbackFor = ClubAlreadyExistException.class)
    public void createPlayer(CreateClubDTO clubDTO) throws ClubAlreadyExistException{

       Optional<Club> optionalClub = clubRepository.findByName(clubDTO.getName());

        if (optionalClub.isPresent()) {
            throw new ClubAlreadyExistException("Club already exists");
        }

        else {
            Club club = new Club();

            club.setName(clubDTO.getName());
            club.setMotto(clubDTO.getMotto());
            club.setPresident(clubDTO.getPresident());
            club.setManager(clubDTO.getManager());
            club.setFoundedYear(clubDTO.getFoundedYear());

            clubRepository.save(club);

        }
    }
}

