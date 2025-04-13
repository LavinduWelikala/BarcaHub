package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.CulerRequestDTO;
import com.lavindu.barcelona_api.controller.response.CulerResponse;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Culer;
import com.lavindu.barcelona_api.service.CulerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CulerControllerMockitoUnitTest {

    @Mock
    private CulerService culerService;

    @InjectMocks
    private CulerController culerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Unit: Register new Culer")
    void testRegisterUser() throws AlreadyExistException {
        CulerRequestDTO request = new CulerRequestDTO();
        request.setName("Vihan");
        request.setAge(25);
        request.setPhone(0771234567);
        request.setEmail("vihan@barca.com");
        request.setCountry("Sri Lanka");
        request.setPassword("secret");

        Culer culer = new Culer();
        culer.setId(1L);
        culer.setName("Vihan");
        culer.setAge(25);
        culer.setPhone(0771234567);
        culer.setEmail("vihan@barca.com");
        culer.setCountry("Sri Lanka");
        culer.setPassword("secret");

        when(culerService.create(any(CulerRequestDTO.class))).thenReturn(culer);

        CulerResponse response = culerController.registerUser(request);

        assertEquals("Vihan", response.getName());
        assertEquals(0771234567, response.getPhone());
        assertEquals("Sri Lanka", response.getCountry());
        assertEquals("vihan@barca.com", response.getEmail());
        assertEquals("secret", response.getPassword());
        assertEquals(1L, response.getCulerId());
    }
}