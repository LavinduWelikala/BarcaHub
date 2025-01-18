package com.lavindu.barcelona_api.repository;

import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.model.Player;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);

    List<Player> findByClub(Club club);
}
