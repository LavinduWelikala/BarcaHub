package com.lavindu.barcelona_api.repository;

import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
