package com.lavindu.barcelona_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavindu.barcelona_api.controller.request.StadiumRequestDTO;
import com.lavindu.barcelona_api.repository.StadiumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StadiumControllerSpringIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StadiumRepository stadiumRepository;

    @BeforeEach
    void setUp() {
        stadiumRepository.deleteAll();
    }

    @Test
    @DisplayName("Integration: Create stadium")
    void testCreateStadium() throws Exception {
        StadiumRequestDTO dto = new StadiumRequestDTO();
        dto.setName("Spotify Camp Nou");
        dto.setLocation("Barcelona");
        dto.setCapacity(99354);

        mockMvc.perform(post("/stadiums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }
}
