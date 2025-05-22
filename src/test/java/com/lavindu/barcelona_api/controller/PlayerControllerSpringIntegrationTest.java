//package com.lavindu.barcelona_api.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lavindu.barcelona_api.controller.request.PlayerRequestDTO;
//import com.lavindu.barcelona_api.model.Club;
//import com.lavindu.barcelona_api.model.Player;
//import com.lavindu.barcelona_api.repository.ClubRepository;
//import com.lavindu.barcelona_api.repository.PlayerRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class PlayerControllerSpringIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private PlayerRepository playerRepository;
//
//    @Autowired
//    private ClubRepository clubRepository;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Club club;
//
//    @BeforeEach
//    void setup() {
//        playerRepository.deleteAll();
//        clubRepository.deleteAll();
//
//        club = new Club();
//        club.setName("FC Barcelona");
//        club.setMotto("Mes Que Un Club");
//        club.setPresident("Joan Laporta");
//        club.setManager("Xavi");
//        club.setFoundedYear(1899);
//        club = clubRepository.save(club);
//    }
//
//    @Test
//    void testCreatePlayerIntegration() throws Exception {
//        PlayerRequestDTO dto = new PlayerRequestDTO();
//        dto.setName("Messi");
//        dto.setAge(36);
//        dto.setNationality("Argentina");
//        dto.setPosition("Forward");
//        dto.setJerseyNumber(10);
//
//        mockMvc.perform(post("/clubs/" + club.getId() + "/players")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(dto)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("Messi")))
//                .andExpect(jsonPath("$.clubId", is(club.getId().intValue())));
//    }
//
//    @Test
//    void testGetAllPlayers() throws Exception {
//        Player player = new Player();
//        player.setName("Messi");
//        player.setAge(36);
//        player.setNationality("Argentina");
//        player.setPosition("Forward");
//        player.setJerseyNumber(10);
//        player.setClub(club);
//        playerRepository.save(player);
//
//        mockMvc.perform(get("/players"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name", is("Messi")));
//    }
//}