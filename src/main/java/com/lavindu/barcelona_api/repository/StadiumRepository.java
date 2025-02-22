package com.lavindu.barcelona_api.repository;

import com.lavindu.barcelona_api.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    Optional<Stadium> findByName(String name);
}
