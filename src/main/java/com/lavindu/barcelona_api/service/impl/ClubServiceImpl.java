package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Override
    public Club create(ClubRequestDTO clubDTO) throws AlreadyExistException{

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
    public List<Club> findAll() {

        return clubRepository.findAll();
    }

    @Override
    public Club findById(Long clubId) throws ClubNotFoundException {

        Club club = clubRepository.findById(clubId).orElseThrow(
                () -> new ClubNotFoundException("Club ID " + clubId + " Not Found")
        );

        return club;
    }

    @Override
    public Club updateById(Long clubId, ClubRequestDTO clubDTO) throws ClubNotFoundException {

        Club club = clubRepository.findById(clubId).orElseThrow(
                () -> new ClubNotFoundException("Club ID " + clubId + " Not Found"));

        club.setName(clubDTO.getName());
        club.setMotto(clubDTO.getMotto());
        club.setPresident(clubDTO.getPresident());
        club.setManager(clubDTO.getManager());
        club.setFoundedYear(clubDTO.getFoundedYear());

        clubRepository.save(club);

        return club;
    }

    @Override
    public void deleteById(Long clubId) {

        clubRepository.deleteById(clubId);
    }


}

