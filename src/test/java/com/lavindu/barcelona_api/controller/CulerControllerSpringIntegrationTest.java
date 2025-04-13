package com.lavindu.barcelona_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavindu.barcelona_api.controller.request.CulerRequestDTO;
import com.lavindu.barcelona_api.model.Culer;
import com.lavindu.barcelona_api.repository.CulerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CulerControllerSpringIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CulerRepository culerRepository;

    @BeforeEach
    void setUp() {
        culerRepository.deleteAll();
    }

    @Test
    @DisplayName("Integration: Register new Culer")
    void testRegisterCuler() throws Exception {
        CulerRequestDTO request = new CulerRequestDTO();
        request.setName("Vihan");
        request.setAge(25);
        request.setPhone(0771234567);
        request.setEmail("vihan@barca.com");
        request.setCountry("Sri Lanka");
        request.setPassword("secret");

        mockMvc.perform(post("/culers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Vihan")))
                .andExpect(jsonPath("$.phone", is(0771234567)))
                .andExpect(jsonPath("$.email", is("vihan@barca.com")))
                .andExpect(jsonPath("$.country", is("Sri Lanka")))
                .andExpect(jsonPath("$.password", is("secret")));
    }
}
