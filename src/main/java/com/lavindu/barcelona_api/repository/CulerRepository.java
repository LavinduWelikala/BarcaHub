package com.lavindu.barcelona_api.repository;

import com.lavindu.barcelona_api.model.Culer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CulerRepository extends JpaRepository<Culer, Long> {

    Optional<Culer> findByName(String name);
}
