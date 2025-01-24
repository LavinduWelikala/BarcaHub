package com.lavindu.barcelona_api.repository;

import com.lavindu.barcelona_api.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepo extends JpaRepository<Club, Long> {


    Optional<Club> findByName(String name);


}
