//package com.lavindu.barcelona_api.service.impl;
//
//import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
//import com.lavindu.barcelona_api.exception.AlreadyExistException;
//import com.lavindu.barcelona_api.exception.ClubNotFoundException;
//import com.lavindu.barcelona_api.model.Club;
//import com.lavindu.barcelona_api.repository.ClubRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ClubServiceImplSpringUnitTest {
//
//    // Inject the service to be tested
//    @InjectMocks
//    private ClubServiceImpl clubService;
//
//    // Mock the repository dependency
//    @Mock
//    private ClubRepository clubRepository;
//
//    private Club getSampleClub() {
//        Club club = new Club();
//        club.setId(1L);
//        club.setName("Barcelona");
//        club.setMotto("Més que un club");
//        club.setPresident("Joan Laporta");
//        club.setManager("Xavi");
//        club.setFoundedYear(1899);
//        return club;
//    }
//
//    private ClubRequestDTO getSampleClubRequestDTO() {
//        ClubRequestDTO dto = new ClubRequestDTO();
//        dto.setName("Barcelona");
//        dto.setMotto("Més que un club");
//        dto.setPresident("Joan Laporta");
//        dto.setManager("Xavi");
//        dto.setFoundedYear(1899);
//        return dto;
//    }
//
//    @Test
//    @DisplayName("Create club successfully")
//    void testCreateClubSuccessfully() throws AlreadyExistException {
//        Club club = getSampleClub();
//        ClubRequestDTO dto = getSampleClubRequestDTO();
//
//        // Mock the repository methods
//        Mockito.when(clubRepository.findByName(dto.getName())).thenReturn(Optional.empty());  // No club with this name exists.
//        Mockito.when(clubRepository.save(Mockito.any(Club.class))).thenReturn(club); // Saving the club.
//
//        // Act
//        Club createdClub = clubService.create(dto);
//
//        // Assert
//        assertNotNull(createdClub);  // Assert that the club was created.
//        assertEquals(dto.getName(), createdClub.getName());  // Assert the club's name matches the DTO.
//    }
//
//    @Test
//    @DisplayName("Create club - already exists")
//    void testCreateClubAlreadyExists() {
//        Club club = getSampleClub();
//        ClubRequestDTO dto = getSampleClubRequestDTO();
//
//        // Mock that the club already exists
//        Mockito.when(clubRepository.findByName(dto.getName())).thenReturn(Optional.of(club));
//
//        // Assert that an exception is thrown
//        assertThrows(AlreadyExistException.class, () -> clubService.create(dto));
//    }
//
//    @Test
//    @DisplayName("Find all clubs")
//    void testFindAllClubs() {
//        Club club1 = getSampleClub();
//        Club club2 = new Club();
//        club2.setId(2L);
//        club2.setName("Real Madrid");
//        club2.setMotto("Hala Madrid");
//        club2.setPresident("Florentino Perez");
//        club2.setManager("Ancelotti");
//        club2.setFoundedYear(1902);
//
//        List<Club> clubs = Arrays.asList(club1, club2);
//        Mockito.when(clubRepository.findAll()).thenReturn(clubs);
//
//        List<Club> result = clubService.findAll();
//
//        assertEquals(2, result.size());
//    }
//
//    @Test
//    @DisplayName("Find club by ID - success")
//    void testFindByIdSuccess() throws ClubNotFoundException {
//        Club club = getSampleClub();
//        club.setId(2L); // ✅ Set ID to match the one you're querying
//        Mockito.when(clubRepository.findById(2L)).thenReturn(Optional.of(club));
//
//        Club foundClub = clubService.findById(2L);
//
//        assertNotNull(foundClub);
//        assertEquals(2L, foundClub.getId()); // ✅ Should now match
//    }
//
//
//    @Test
//    @DisplayName("Find club by ID - not found")
//    void testFindByIdNotFound() {
//        Mockito.when(clubRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(ClubNotFoundException.class, () -> clubService.findById(1L));
//    }
//
//    @Test
//    @DisplayName("Update club by ID - success")
//    void testUpdateByIdSuccess() throws ClubNotFoundException {
//        Club existingClub = getSampleClub();
//        ClubRequestDTO dto = new ClubRequestDTO();
//        dto.setName("Updated Club");
//        dto.setMotto("New Motto");
//        dto.setPresident("New President");
//        dto.setManager("New Manager");
//        dto.setFoundedYear(2000);
//
//        Mockito.when(clubRepository.findById(1L)).thenReturn(Optional.of(existingClub));
//        Mockito.when(clubRepository.save(Mockito.any(Club.class))).thenReturn(existingClub);
//
//        Club updatedClub = clubService.updateById(1L, dto);
//
//        assertNotNull(updatedClub);
//        assertEquals("Updated Club", updatedClub.getName());
//        assertEquals("New Motto", updatedClub.getMotto());
//    }
//
//    @Test
//    @DisplayName("Delete club by ID - success")
//    void testDeleteById() {
//        Club club = getSampleClub();
//        Mockito.when(clubRepository.findById(1L)).thenReturn(Optional.of(club));
//
//        clubService.deleteById(1L);
//
//        Mockito.verify(clubRepository, Mockito.times(1)).deleteById(1L);  // Verify that deleteById was called once
//    }
//}
