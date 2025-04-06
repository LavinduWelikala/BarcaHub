//package com.lavindu.barcelona_api.service.impl;
//
//import com.lavindu.barcelona_api.controller.request.StadiumRequestDTO;
//import com.lavindu.barcelona_api.exception.AlreadyExistException;
//import com.lavindu.barcelona_api.model.Stadium;
//import com.lavindu.barcelona_api.repository.StadiumRepository;
//import com.lavindu.barcelona_api.service.StadiumService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional // Ensures DB resets after each test
//class StadiumServiceImplSpringIntegrationTest {
//
//    @Autowired
//    private StadiumService stadiumService;
//
//    @Autowired
//    private StadiumRepository stadiumRepository;
//
//    private StadiumRequestDTO getSampleStadiumDTO() {
//        StadiumRequestDTO dto = new StadiumRequestDTO();
//        dto.setName("Camp Nou");
//        dto.setLocation("Barcelona, Spain");
//        dto.setCapacity(99354);
//        return dto;
//    }
//
//    @Test
//    @DisplayName("Create stadium successfully (Integration)")
//    void testCreateStadiumSuccessfully() throws AlreadyExistException {
//        StadiumRequestDTO dto = getSampleStadiumDTO();
//
//        stadiumService.createStadium(dto);
//
//        Optional<Stadium> stadium = stadiumRepository.findByName("Camp Nou");
//        assertTrue(stadium.isPresent());
//        assertEquals("Barcelona, Spain", stadium.get().getLocation());
//    }
//
//    @Test
//    @DisplayName("Create stadium already exists (Integration)")
//    void testCreateStadiumAlreadyExists() throws AlreadyExistException {
//        // First insert
//        StadiumRequestDTO dto = getSampleStadiumDTO();
//        stadiumService.createStadium(dto);
//
//        // Second attempt should fail
//        assertThrows(AlreadyExistException.class, () -> stadiumService.createStadium(dto));
//    }
//}
