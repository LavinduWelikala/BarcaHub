//package com.lavindu.barcelona_api.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lavindu.barcelona_api.controller.request.PlayerRequestDTO;
//import com.lavindu.barcelona_api.model.Club;
//import com.lavindu.barcelona_api.model.Player;
//import com.lavindu.barcelona_api.service.PlayerService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.hamcrest.Matchers.is;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//class PlayerControllerMockitoUnitTest {
//
//    private PlayerService playerService;
//    private MockMvc mockMvc;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        playerService = Mockito.mock(PlayerService.class);
//        PlayerController controller = new PlayerController(playerService);
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void testCreatePlayer() throws Exception {
//        PlayerRequestDTO dto = new PlayerRequestDTO();
//        dto.setName("Messi");
//        dto.setAge(36);
//        dto.setNationality("Argentina");
//        dto.setPosition("Forward");
//        dto.setJerseyNumber(10);
//
//        Club club = new Club();
//        club.setId(1L);
//
//        Player player = new Player();
//        player.setId(1L);
//        player.setName("Messi");
//        player.setAge(36);
//        player.setNationality("Argentina");
//        player.setPosition("Forward");
//        player.setJerseyNumber(10);
//        player.setClub(club);
//
//        when(playerService.create(eq(1L), any(PlayerRequestDTO.class))).thenReturn(player);
//
//        mockMvc.perform(post("/clubs/1/players")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(dto)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("Messi")))
//                .andExpect(jsonPath("$.clubId", is(1)));
//    }
//
//    @Test
//    void testGetPlayerById() throws Exception {
//        Club club = new Club();
//        club.setId(1L);
//
//        Player player = new Player();
//        player.setId(1L);
//        player.setName("Messi");
//        player.setAge(36);
//        player.setNationality("Argentina");
//        player.setPosition("Forward");
//        player.setJerseyNumber(10);
//        player.setClub(club);
//
//        when(playerService.findById(1L)).thenReturn(player);
//
//        mockMvc.perform(get("/players/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("Messi")))
//                .andExpect(jsonPath("$.clubId", is(1)));
//    }
//
//    @Test
//    void testDeletePlayerById() throws Exception {
//        doNothing().when(playerService).deleteById(1L);
//
//        mockMvc.perform(delete("/players/1"))
//                .andExpect(status().isOk());
//    }
//}
