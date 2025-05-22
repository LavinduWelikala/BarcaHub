package com.lavindu.barcelona_api.service.impl;

import com.cloudinary.Cloudinary;
import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private Cloudinary cloudinary;
    private ClubRepository clubRepository;

    @Override
    public Club create(ClubRequestDTO clubDTO) throws AlreadyExistException, IOException {

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

            List<String> imageUrls = new ArrayList<>();
            if (clubDTO.getImageFiles() != null) {
                for (MultipartFile file : clubDTO.getImageFiles()) {
                    String imageUrl = cloudinary.uploader()
                            .upload(file.getBytes(),
                                    Map.of("public_id", UUID.randomUUID().toString()))
                            .get("url")
                            .toString();
                    imageUrls.add(imageUrl);
                }
            }
            club.setImageUrl(imageUrls);
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

//    @Override
//    public Club updateById(Long clubId, ClubRequestDTO clubDTO) throws ClubNotFoundException {
//
//        Club club = clubRepository.findById(clubId).orElseThrow(
//                () -> new ClubNotFoundException("Club ID " + clubId + " Not Found"));
//
//        club.setName(clubDTO.getName());
//        club.setMotto(clubDTO.getMotto());
//        club.setPresident(clubDTO.getPresident());
//        club.setManager(clubDTO.getManager());
//        club.setFoundedYear(clubDTO.getFoundedYear());
//
//        clubRepository.save(club);
//
//        return club;
//    }

    @Override
    public void deleteById(Long clubId) {

        clubRepository.deleteById(clubId);
    }


}

