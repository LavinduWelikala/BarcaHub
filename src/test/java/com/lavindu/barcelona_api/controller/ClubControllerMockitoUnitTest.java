//package com.lavindu.barcelona_api.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lavindu.barcelona_api.controller.request.ClubRequestDTO;
//import com.lavindu.barcelona_api.model.Club;
//import com.lavindu.barcelona_api.service.ClubService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(controllers = ClubController.class)
//@Import(ClubControllerMockitoUnitTest.MockConfig.class)
//class ClubControllerMockitoUnitTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private ClubService clubService;
//
//    @TestConfiguration
//    static class MockConfig {
//        @Bean
//        public ClubService clubService() {
//            return Mockito.mock(ClubService.class);
//        }
//    }
//
//    @Test
//    @DisplayName("Create new club")
//    void testCreateClub() throws Exception {
//        ClubRequestDTO requestDTO = new ClubRequestDTO();
//        requestDTO.setName("FC Barcelona");
//        requestDTO.setMotto("Mes Que Un Club");
//        requestDTO.setPresident("Joan Laporta");
//        requestDTO.setManager("Xavi");
//        requestDTO.setFoundedYear(1899);
//
//        Club club = new Club();
//        club.setId(1L);
//        club.setName(requestDTO.getName());
//        club.setMotto(requestDTO.getMotto());
//        club.setPresident(requestDTO.getPresident());
//        club.setManager(requestDTO.getManager());
//        club.setFoundedYear(requestDTO.getFoundedYear());
//
//        Mockito.when(clubService.create(any(ClubRequestDTO.class))).thenReturn(club);
//
//        mockMvc.perform(post("/clubs")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(requestDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(club.getId().intValue())))
//                .andExpect(jsonPath("$.name", is(club.getName())))
//                .andExpect(jsonPath("$.motto", is(club.getMotto())))
//                .andExpect(jsonPath("$.president", is(club.getPresident())))
//                .andExpect(jsonPath("$.manager", is(club.getManager())))
//                .andExpect(jsonPath("$.foundedYear", is(club.getFoundedYear())));
//    }
//
//    @Test
//    @DisplayName("Get all clubs")
//    void testGetAllClubs() throws Exception {
//        Club club1 = new Club();
//        club1.setId(1L);
//        club1.setName("FC Barcelona");
//
//        Club club2 = new Club();
//        club2.setId(2L);
//        club2.setName("Real Madrid");
//
//        Mockito.when(clubService.findAll()).thenReturn(List.of(club1, club2));
//
//        mockMvc.perform(get("/clubs"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(club1.getId().intValue())))
//                .andExpect(jsonPath("$[0].name", is(club1.getName())))
//                .andExpect(jsonPath("$[1].id", is(club2.getId().intValue())))
//                .andExpect(jsonPath("$[1].name", is(club2.getName())));
//    }
//
//    @Test
//    @DisplayName("Get club by ID")
//    void testGetClubById() throws Exception {
//        Long clubId = 1L;
//        Club club = new Club();
//        club.setId(clubId);
//        club.setName("FC Barcelona");
//        club.setMotto("Mes Que Un Club");
//        club.setPresident("Joan Laporta");
//        club.setManager("Xavi");
//        club.setFoundedYear(1899);
//
//        Mockito.when(clubService.findById(clubId)).thenReturn(club);
//
//        mockMvc.perform(get("/clubs/{club-id}", clubId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(club.getId().intValue())))
//                .andExpect(jsonPath("$.name", is(club.getName())))
//                .andExpect(jsonPath("$.motto", is(club.getMotto())))
//                .andExpect(jsonPath("$.president", is(club.getPresident())))
//                .andExpect(jsonPath("$.manager", is(club.getManager())))
//                .andExpect(jsonPath("$.foundedYear", is(club.getFoundedYear())));
//    }
//
//    @Test
//    @DisplayName("Update club by ID")
//    void testUpdateClubById() throws Exception {
//        Long clubId = 1L;
//        ClubRequestDTO updateDTO = new ClubRequestDTO();
//        updateDTO.setName("Barça Updated");
//        updateDTO.setMotto("Updated Motto");
//        updateDTO.setPresident("Updated President");
//        updateDTO.setManager("Updated Manager");
//        updateDTO.setFoundedYear(1900);
//
//        Club updatedClub = new Club();
//        updatedClub.setId(clubId);
//        updatedClub.setName(updateDTO.getName());
//        updatedClub.setMotto(updateDTO.getMotto());
//        updatedClub.setPresident(updateDTO.getPresident());
//        updatedClub.setManager(updateDTO.getManager());
//        updatedClub.setFoundedYear(updateDTO.getFoundedYear());
//
//        Mockito.when(clubService.updateById(eq(clubId), any(ClubRequestDTO.class)))
//                .thenReturn(updatedClub);
//
//        mockMvc.perform(put("/clubs/{club-id}", clubId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updateDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(clubId.intValue())))
//                .andExpect(jsonPath("$.name", is(updatedClub.getName())))
//                .andExpect(jsonPath("$.motto", is(updatedClub.getMotto())))
//                .andExpect(jsonPath("$.president", is(updatedClub.getPresident())))
//                .andExpect(jsonPath("$.manager", is(updatedClub.getManager())))
//                .andExpect(jsonPath("$.foundedYear", is(updatedClub.getFoundedYear())));
//    }
//
//    @Test
//    @DisplayName("Delete club by ID")
//    void testDeleteClubById() throws Exception {
//        Long clubId = 1L;
//
//        Mockito.doNothing().when(clubService).deleteById(clubId);
//
//        mockMvc.perform(delete("/clubs/{club-id}", clubId))
//                .andExpect(status().isOk());
//    }
//}
