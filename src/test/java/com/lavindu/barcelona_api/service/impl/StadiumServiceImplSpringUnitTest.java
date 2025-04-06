package com.lavindu.barcelona_api.service.impl;

import com.lavindu.barcelona_api.controller.request.StadiumRequestDTO;
import com.lavindu.barcelona_api.exception.AlreadyExistException;
import com.lavindu.barcelona_api.model.Stadium;
import com.lavindu.barcelona_api.repository.StadiumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StadiumServiceImplSpringUnitTest {

    @Mock
    private StadiumRepository stadiumRepository;

    @InjectMocks
    private StadiumServiceImpl stadiumService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private StadiumRequestDTO getSampleStadiumDTO() {
        StadiumRequestDTO dto = new StadiumRequestDTO();
        dto.setName("Camp Nou");
        dto.setLocation("Barcelona, Spain");
        dto.setCapacity(99354);
        return dto;
    }

    private Stadium getSampleStadium() {
        Stadium stadium = new Stadium();
        stadium.setId(1L);
        stadium.setName("Camp Nou");
        stadium.setLocation("Barcelona, Spain");
        stadium.setCapacity(99354);
        return stadium;
    }

    @Test
    @DisplayName("Create stadium successfully")
    void testCreateStadiumSuccessfully() throws AlreadyExistException {
        StadiumRequestDTO dto = getSampleStadiumDTO();

        when(stadiumRepository.findByName(dto.getName())).thenReturn(Optional.empty());

        stadiumService.createStadium(dto);

        verify(stadiumRepository, times(1)).save(any(Stadium.class));
    }

    @Test
    @DisplayName("Create stadium already exists")
    void testCreateStadiumAlreadyExists() {
        StadiumRequestDTO dto = getSampleStadiumDTO();
        when(stadiumRepository.findByName(dto.getName())).thenReturn(Optional.of(getSampleStadium()));

        assertThrows(AlreadyExistException.class, () -> stadiumService.createStadium(dto));
        verify(stadiumRepository, never()).save(any(Stadium.class));
    }
}
