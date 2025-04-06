package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.PlayerRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.NotFoundException;
import com.lavindu.barcelona_api.exception.PlayerNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.model.Player;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.repository.PlayerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PlayerServiceImplSpringIntegrationTest {

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private ClubRepository clubRepository;

    private Club getSampleClub() {
        Club club = new Club();
        club.setId(1L);
        club.setName("Barcelona");
        return club;
    }

    private PlayerRequestDTO getSamplePlayerDTO() {
        PlayerRequestDTO dto = new PlayerRequestDTO();
        dto.setName("Lionel Messi");
        dto.setAge(35);
        dto.setPosition("Forward");
        dto.setNationality("Argentina");
        dto.setJerseyNumber(10);
        return dto;
    }

    private Player getSamplePlayer() {
        Player player = new Player();
        player.setId(1L);
        player.setName("Lionel Messi");
        player.setAge(35);
        player.setPosition("Forward");
        player.setNationality("Argentina");
        player.setJerseyNumber(10);
        player.setClub(getSampleClub());
        return player;
    }

    @Test
    @DisplayName("Create Player - Success")
    void testCreatePlayerSuccessfully() throws AlreadyExistException, PlayerNotFoundException {
        PlayerRequestDTO dto = getSamplePlayerDTO();
        Club club = getSampleClub();
        Player player = getSamplePlayer();

        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));
        when(playerRepository.findByNameAndClubId(dto.getName(), 1L)).thenReturn(Optional.empty());
        when(playerRepository.save(any(Player.class))).thenReturn(player);

        Player created = playerService.create(1L, dto);

        assertNotNull(created);
        assertEquals(dto.getName(), created.getName());
        verify(playerRepository).save(any(Player.class));
    }

    @Test
    @DisplayName("Create Player - Already Exists")
    void testCreatePlayerAlreadyExists() {
        PlayerRequestDTO dto = getSamplePlayerDTO();
        Club club = getSampleClub();
        Player player = getSamplePlayer();

        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));
        when(playerRepository.findByNameAndClubId(dto.getName(), 1L)).thenReturn(Optional.of(player));

        assertThrows(AlreadyExistException.class, () -> playerService.create(1L, dto));
    }

    @Test
    @DisplayName("Find All Players - Success")
    void testFindAllPlayers() {
        List<Player> players = Arrays.asList(getSamplePlayer(), getSamplePlayer());
        when(playerRepository.findAll()).thenReturn(players);

        List<Player> result = playerService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Find All Players by Club ID - Success")
    void testFindAllPlayersByClubId() throws NotFoundException {
        Club club = getSampleClub();
        List<Player> players = Arrays.asList(getSamplePlayer());

        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));
        when(playerRepository.findByClub(club)).thenReturn(players);

        List<Player> result = playerService.findAllByClubId(1L);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Find Player by ID - Success")
    void testFindPlayerById() throws PlayerNotFoundException {
        Player player = getSamplePlayer();
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        Player result = playerService.findById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("Update Player by ID - Success")
    void testUpdatePlayerById() throws PlayerNotFoundException {
        Player existingPlayer = getSamplePlayer();
        PlayerRequestDTO dto = getSamplePlayerDTO();
        dto.setName("Updated Name");

        when(playerRepository.findById(1L)).thenReturn(Optional.of(existingPlayer));
        when(playerRepository.save(any(Player.class))).thenReturn(existingPlayer);

        Player updated = playerService.updateById(1L, dto);
        assertEquals("Updated Name", updated.getName());
    }

    @Test
    @DisplayName("Delete Player by ID - Success")
    void testDeletePlayerById() {
        playerService.deleteById(1L);
        verify(playerRepository, times(1)).deleteById(1L);
    }
}
