//package com.lavindu.barcelona_api.service.impl;
//
//import com.lavindu.barcelona_api.controller.request.CulerRequestDTO;
//import com.lavindu.barcelona_api.exception.AlreadyExistException;
//import com.lavindu.barcelona_api.model.Culer;
//import com.lavindu.barcelona_api.repository.CulerRepository;
//import com.lavindu.barcelona_api.service.CulerService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class CulerServiceImplSpringIntegrationTest {
//
//    @Autowired
//    private CulerService culerService;
//
//    @Autowired
//    private CulerRepository culerRepository;
//
//    private CulerRequestDTO getSampleCulerDTO() {
//        CulerRequestDTO dto = new CulerRequestDTO();
//        dto.setName("Vihan");
//        dto.setEmail("vihan@example.com");
//        dto.setPhone(1234567890);
//        dto.setAge(25);
//        dto.setCountry("Sri Lanka");
//        dto.setPassword("password123");
//        return dto;
//    }
//
//    @BeforeEach
//    void cleanDb() {
//        culerRepository.deleteAll();
//    }
//
//    @Test
//    @DisplayName("Create culer successfully - Integration")
//    void testCreateCulerSuccessfully() throws AlreadyExistException {
//        CulerRequestDTO dto = getSampleCulerDTO();
//
//        Culer created = culerService.create(dto);
//
//        assertNotNull(created);
//        assertEquals(dto.getName(), created.getName());
//        assertEquals(1, culerRepository.count());
//    }
//
//    @Test
//    @DisplayName("Throw AlreadyExistException when culer already exists - Integration")
//    void testCreateCulerAlreadyExists() {
//        CulerRequestDTO dto = getSampleCulerDTO();
//
//        // Save a Culer first
//        Culer existing = new Culer();
//        existing.setName(dto.getName());
//        existing.setEmail(dto.getEmail());
//        existing.setPhone(dto.getPhone());
//        existing.setAge(dto.getAge());
//        existing.setCountry(dto.getCountry());
//        existing.setPassword(dto.getPassword());
//
//        culerRepository.save(existing);
//
//        assertThrows(AlreadyExistException.class, () -> culerService.create(dto));
//        assertEquals(1, culerRepository.count());
//    }
//}
