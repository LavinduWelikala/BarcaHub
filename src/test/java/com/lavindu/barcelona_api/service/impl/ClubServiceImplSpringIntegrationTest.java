package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.exception.ClubNotFoundException;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.repository.ClubRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  // Use MockitoExtension to enable @Mock and @InjectMocks
class ClubServiceImplSpringIntegrationTest {

    @InjectMocks
    private ClubServiceImpl clubService; // Injecting the service under test

    @Mock
    private ClubRepository clubRepository;  // Mocking the ClubRepository

    private Club getSampleClub() {
        Club club = new Club();
        club.setId(1L);
        club.setName("Barcelona");
        club.setMotto("Més que un club");
        club.setPresident("Joan Laporta");
        club.setManager("Xavi");
        club.setFoundedYear(1899);
        return club;
    }

    private ClubRequestDTO getSampleClubRequestDTO() {
        ClubRequestDTO dto = new ClubRequestDTO();
        dto.setName("Barcelona");
        dto.setMotto("Més que un club");
        dto.setPresident("Joan Laporta");
        dto.setManager("Xavi");
        dto.setFoundedYear(1899);
        return dto;
    }

    @BeforeEach
    public void clearDB() {
        Mockito.reset(clubRepository);  // Reset the mocks before each test
    }

    @Test
    @DisplayName("Create club successfully")
    void testCreateClubSuccessfully() throws AlreadyExistException {
        Club club = getSampleClub();
        ClubRequestDTO dto = getSampleClubRequestDTO();

        // Mock the repository
        Mockito.when(clubRepository.findByName(dto.getName())).thenReturn(Optional.empty());
        Mockito.when(clubRepository.save(Mockito.any(Club.class))).thenReturn(club);

        Club createdClub = clubService.create(dto);

        assertNotNull(createdClub);
        assertEquals(dto.getName(), createdClub.getName());
    }

    @Test
    @DisplayName("Create club - already exists")
    void testCreateClubAlreadyExists() {
        Club club = getSampleClub();
        ClubRequestDTO dto = getSampleClubRequestDTO();

        // Mock the repository
        Mockito.when(clubRepository.findByName(dto.getName())).thenReturn(Optional.of(club));

        assertThrows(AlreadyExistException.class, () -> clubService.create(dto));
    }

    @Test
    @DisplayName("Find all clubs")
    void testFindAllClubs() {
        Club club1 = getSampleClub();
        Club club2 = new Club();
        club2.setId(2L);
        club2.setName("Real Madrid");
        club2.setMotto("Hala Madrid");
        club2.setPresident("Florentino Perez");
        club2.setManager("Ancelotti");
        club2.setFoundedYear(1902);

        List<Club> clubs = Arrays.asList(club1, club2);
        Mockito.when(clubRepository.findAll()).thenReturn(clubs);

        List<Club> result = clubService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Find club by ID - success")
    void testFindByIdSuccess() throws ClubNotFoundException {
        Club club = getSampleClub();
        club.setId(2L); // Ensure the ID is 2 for this test
        Mockito.when(clubRepository.findById(2L)).thenReturn(Optional.of(club));

        Club foundClub = clubService.findById(2L);

        assertNotNull(foundClub);
        assertEquals(2L, foundClub.getId()); // Assert the ID is 2
    }

    @Test
    @DisplayName("Find club by ID - not found")
    void testFindByIdNotFound() {
        Mockito.when(clubRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ClubNotFoundException.class, () -> clubService.findById(1L));
    }

    @Test
    @DisplayName("Update club by ID - success")
    void testUpdateByIdSuccess() throws ClubNotFoundException {
        Club existingClub = getSampleClub();
        existingClub.setId(1L);

        ClubRequestDTO dto = new ClubRequestDTO();
        dto.setName("Updated Club");
        dto.setMotto("New Motto");
        dto.setPresident("New President");
        dto.setManager("New Manager");
        dto.setFoundedYear(2000);

        // Mock the repository
        Mockito.when(clubRepository.findById(1L)).thenReturn(Optional.of(existingClub));
        Mockito.when(clubRepository.save(Mockito.any(Club.class))).thenReturn(existingClub);

        Club updatedClub = clubService.updateById(1L, dto);

        assertNotNull(updatedClub);
        assertEquals("Updated Club", updatedClub.getName());
        assertEquals("New Motto", updatedClub.getMotto());
    }

    @Test
    @DisplayName("Delete club by ID - success")
    void testDeleteById() {
        Club club = getSampleClub();
        club.setId(1L);

        // Lenient stubbing for the unused methods
        Mockito.lenient().when(clubRepository.findById(1L)).thenReturn(Optional.of(club));

        clubService.deleteById(1L);

        Mockito.verify(clubRepository, Mockito.times(1)).deleteById(1L);
    }

}
