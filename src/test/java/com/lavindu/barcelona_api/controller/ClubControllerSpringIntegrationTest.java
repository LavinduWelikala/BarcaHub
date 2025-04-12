package com.lavindu.barcelona_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
import com.lavindu.barcelona_api.model.Club;
import com.lavindu.barcelona_api.repository.ClubRepository;
import com.lavindu.barcelona_api.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClubControllerSpringIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private PlayerRepository playerRepository;  // Used to delete players if needed

    @BeforeEach
    void setUp() {
        playerRepository.deleteAll(); // Ensure there are no players left
        clubRepository.deleteAll(); // Delete all clubs after players
    }

    @Test
    @DisplayName("Integration: Create new club")
    void testCreateClub() throws Exception {
        ClubRequestDTO requestDTO = new ClubRequestDTO();
        requestDTO.setName("FC Barcelona");
        requestDTO.setMotto("Mes Que Un Club");
        requestDTO.setPresident("Joan Laporta");
        requestDTO.setManager("Xavi");
        requestDTO.setFoundedYear(1899);

        mockMvc.perform(post("/clubs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("FC Barcelona")))
                .andExpect(jsonPath("$.motto", is("Mes Que Un Club")))
                .andExpect(jsonPath("$.president", is("Joan Laporta")))
                .andExpect(jsonPath("$.manager", is("Xavi")))
                .andExpect(jsonPath("$.foundedYear", is(1899)));
    }

    @Test
    @DisplayName("Integration: Get all clubs")
    void testGetAllClubs() throws Exception {
        Club club1 = new Club();
        club1.setName("Barcelona");
        club1.setMotto("Motto1");
        club1.setPresident("Laporta");
        club1.setManager("Xavi");
        club1.setFoundedYear(1899);
        clubRepository.save(club1);

        Club club2 = new Club();
        club2.setName("Real Madrid");
        club2.setMotto("Motto2");
        club2.setPresident("Perez");
        club2.setManager("Ancelotti");
        club2.setFoundedYear(1902);
        clubRepository.save(club2);

        mockMvc.perform(get("/clubs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Barcelona")))
                .andExpect(jsonPath("$[1].name", is("Real Madrid")));
    }

    @Test
    @DisplayName("Integration: Get club by ID")
    void testGetClubById() throws Exception {
        Club club = new Club();
        club.setName("Barcelona");
        club.setMotto("Motto");
        club.setPresident("Laporta");
        club.setManager("Xavi");
        club.setFoundedYear(1899);
        club = clubRepository.save(club);

        mockMvc.perform(get("/clubs/{club-id}", club.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(club.getId().intValue())))
                .andExpect(jsonPath("$.name", is("Barcelona")))
                .andExpect(jsonPath("$.motto", is("Motto")))
                .andExpect(jsonPath("$.president", is("Laporta")))
                .andExpect(jsonPath("$.manager", is("Xavi")))
                .andExpect(jsonPath("$.foundedYear", is(1899)));
    }

    @Test
    @DisplayName("Integration: Update club by ID")
    void testUpdateClubById() throws Exception {
        Club club = new Club();
        club.setName("Old Name");
        club.setMotto("Old Motto");
        club.setPresident("Old Pres");
        club.setManager("Old Manager");
        club.setFoundedYear(1800);
        club = clubRepository.save(club);

        ClubRequestDTO updateDTO = new ClubRequestDTO();
        updateDTO.setName("New Name");
        updateDTO.setMotto("New Motto");
        updateDTO.setPresident("New Pres");
        updateDTO.setManager("New Manager");
        updateDTO.setFoundedYear(1900);

        mockMvc.perform(put("/clubs/{club-id}", club.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("New Name")))
                .andExpect(jsonPath("$.motto", is("New Motto")))
                .andExpect(jsonPath("$.president", is("New Pres")))
                .andExpect(jsonPath("$.manager", is("New Manager")))
                .andExpect(jsonPath("$.foundedYear", is(1900)));
    }

    @Test
    @DisplayName("Integration: Delete club by ID")
    void testDeleteClubById() throws Exception {
        Club club = new Club();
        club.setName("To Delete");
        club.setMotto("Motto");
        club.setPresident("Pres");
        club.setManager("Manager");
        club.setFoundedYear(1900);
        club = clubRepository.save(club);

        mockMvc.perform(delete("/clubs/{club-id}", club.getId()))
                .andExpect(status().isOk());
    }
}
