package com.lavindu.barcelona_api.controller;

import com.lavindu.barcelona_api.controller.request.StadiumRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.service.StadiumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class StadiumControllerMockitoUnitTest {

    @Mock
    private StadiumService stadiumService;

    @InjectMocks
    private StadiumController stadiumController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Unit: Should delegate stadium creation to service")
    void testCreateStadium() throws AlreadyExistException {
        StadiumRequestDTO dto = new StadiumRequestDTO();
        dto.setName("Camp Nou");
        dto.setLocation("Barcelona");
        dto.setCapacity(99354);

        stadiumController.create(dto);

        verify(stadiumService, times(1)).createStadium(dto);
    }
}