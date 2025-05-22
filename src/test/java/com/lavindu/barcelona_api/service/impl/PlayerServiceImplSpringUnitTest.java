//package com.lavindu.barcelona_api.service.impl;
//
//import com.lavindu.barcelona_api.controller.request.PlayerRequestDTO;
//import com.lavindu.barcelona_api.exception.AlreadyExistException;
//import com.lavindu.barcelona_api.exception.NotFoundException;
//import com.lavindu.barcelona_api.exception.PlayerNotFoundException;
//import com.lavindu.barcelona_api.model.Club;
//import com.lavindu.barcelona_api.model.Player;
//import com.lavindu.barcelona_api.repository.ClubRepository;
//import com.lavindu.barcelona_api.repository.PlayerRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class PlayerServiceImplSpringUnitTest {
//
//    @InjectMocks
//    private PlayerServiceImpl playerService;
//
//    @Mock
//    private PlayerRepository playerRepository;
//
//    @Mock
//    private ClubRepository clubRepository;
//
//    private Player getSamplePlayer() {
//        Player player = new Player();
//        player.setId(1L);
//        player.setName("Lionel Messi");
//        player.setAge(34);
//        player.setPosition("Forward");
//        player.setNationality("Argentina");
//        player.setJerseyNumber(10);
//        return player;
//    }
//
//    private PlayerRequestDTO getSamplePlayerRequestDTO() {
//        PlayerRequestDTO dto = new PlayerRequestDTO();
//        dto.setName("Lionel Messi");
//        dto.setAge(34);
//        dto.setPosition("Forward");
//        dto.setNationality("Argentina");
//        dto.setJerseyNumber(10);
//        return dto;
//    }
//
//    @Test
//    @DisplayName("Create player successfully")
//    void testCreatePlayerSuccessfully() throws AlreadyExistException, PlayerNotFoundException {
//        // Step 1: Create a sample club (mocked response)
//        Club club = new Club();
//        club.setId(1L);
//        club.setName("FC Barcelona");
//
//        // Step 2: Create a sample playerDTO
//        PlayerRequestDTO playerDTO = new PlayerRequestDTO();
//        playerDTO.setName("Lionel Messi");
//        playerDTO.setAge(34);
//        playerDTO.setPosition("Forward");
//        playerDTO.setNationality("Argentina");
//        playerDTO.setJerseyNumber(10);
//
//        // Step 3: Mock the clubRepository to return the club when findById is called with ID 1
//        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));
//
//        // Step 4: Mock the playerRepository to return an empty Optional when checking for existing players with the same name and club ID
//        when(playerRepository.findByNameAndClubId(playerDTO.getName(), 1L)).thenReturn(Optional.empty());
//
//        // Step 5: Mock the playerRepository.save() to return the created player
//        Player savedPlayer = new Player();
//        savedPlayer.setId(1L);
//        savedPlayer.setName("Lionel Messi");
//        savedPlayer.setAge(34);
//        savedPlayer.setPosition("Forward");
//        savedPlayer.setNationality("Argentina");
//        savedPlayer.setJerseyNumber(10);
//        savedPlayer.setClub(club);
//
//        when(playerRepository.save(any(Player.class))).thenReturn(savedPlayer);
//
//        // Step 6: Call the method to test
//        Player createdPlayer = playerService.create(1L, playerDTO);
//
//        // Step 7: Assertions to verify that the player was created successfully
//        assertNotNull(createdPlayer);
//        assertEquals("Lionel Messi", createdPlayer.getName());
//        assertEquals(34, createdPlayer.getAge());
//        assertEquals("Forward", createdPlayer.getPosition());
//        assertEquals("Argentina", createdPlayer.getNationality());
//        assertEquals(10, createdPlayer.getJerseyNumber());
//        assertEquals(club, createdPlayer.getClub());
//    }
//
//
//    @Test
//    @DisplayName("Create player - player already exists")
//    void testCreatePlayerAlreadyExists() throws PlayerNotFoundException {
//        PlayerRequestDTO dto = getSamplePlayerRequestDTO();
//        Club club = new Club();
//        club.setId(1L);
//
//        // Create an existing player that should cause AlreadyExistException
//        Player existingPlayer = getSamplePlayer();
//        existingPlayer.setName(dto.getName());
//        existingPlayer.setClub(club);
//
//        // Mock club repository to return the club
//        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));
//
//        // Mock player repository to return an existing player
//        when(playerRepository.findByNameAndClubId(dto.getName(), 1L)).thenReturn(Optional.of(existingPlayer));
//
//        // Expecting AlreadyExistException
//        assertThrows(AlreadyExistException.class, () -> playerService.create(1L, dto));
//    }
//
//
//    @Test
//    @DisplayName("Delete player by ID - success")
//    void testDeletePlayerById() {
//        Player player = getSamplePlayer();
//
//        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));
//
//        playerService.deleteById(1L);
//
//        verify(playerRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    @DisplayName("Find all players")
//    void testFindAllPlayers() {
//        // Sample players for mocking
//        Player player1 = new Player();
//        player1.setId(1L);
//        player1.setName("Player 1");
//
//        Player player2 = new Player();
//        player2.setId(2L);
//        player2.setName("Player 2");
//
//        // Mock player repository to return a list of players
//        when(playerRepository.findAll()).thenReturn(Arrays.asList(player1, player2));
//
//        // Call the method to test
//        List<Player> players = playerService.findAll();
//
//        // Assert that the size of the returned list is 2
//        assertEquals(2, players.size());
//    }
//
//
//    @Test
//    @DisplayName("Find player by ID")
//    void testFindPlayerById() throws PlayerNotFoundException {
//        Player player = getSamplePlayer();
//
//        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));
//
//        Player foundPlayer = playerService.findById(1L);
//
//        assertNotNull(foundPlayer);
//        assertEquals(1L, foundPlayer.getId());
//    }
//
//    @Test
//    @DisplayName("Update player by ID - success")
//    void testUpdatePlayerById() throws PlayerNotFoundException {
//        Player existingPlayer = getSamplePlayer();
//        PlayerRequestDTO dto = new PlayerRequestDTO();
//        dto.setName("Updated Name");
//        dto.setAge(35);
//        dto.setPosition("Midfielder");
//        dto.setNationality("Argentina");
//        dto.setJerseyNumber(10);
//
//        when(playerRepository.findById(1L)).thenReturn(Optional.of(existingPlayer));
//        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(existingPlayer);
//
//        Player updatedPlayer = playerService.updateById(1L, dto);
//
//        assertNotNull(updatedPlayer);
//        assertEquals("Updated Name", updatedPlayer.getName());
//        assertEquals(35, updatedPlayer.getAge());
//    }
//}
