//package com.lavindu.barcelona_api.service.impl;
//
//import com.lavindu.barcelona_api.controller.request.CulerRequestDTO;
//import com.lavindu.barcelona_api.exception.AlreadyExistException;
//import com.lavindu.barcelona_api.model.Culer;
//import com.lavindu.barcelona_api.repository.CulerRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class CulerServiceImplSpringUnitTest {
//
//    @Mock
//    private CulerRepository culerRepository;
//
//    @InjectMocks
//    private CulerServiceImpl culerService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
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
//    private Culer getSampleCuler() {
//        Culer culer = new Culer();
//        culer.setId(1L);
//        culer.setName("Vihan");
//        culer.setEmail("vihan@example.com");
//        culer.setPhone(1234567890);
//        culer.setAge(25);
//        culer.setCountry("Sri Lanka");
//        culer.setPassword("password123");
//        return culer;
//    }
//
//    @Test
//    @DisplayName("Create culer successfully")
//    void testCreateCulerSuccessfully() throws AlreadyExistException {
//        CulerRequestDTO dto = getSampleCulerDTO();
//        Culer expectedCuler = getSampleCuler();
//
//        when(culerRepository.findByName(dto.getName())).thenReturn(Optional.empty());
//        when(culerRepository.save(any(Culer.class))).thenReturn(expectedCuler);
//
//        Culer created = culerService.create(dto);
//
//        assertNotNull(created);
//        assertEquals(dto.getName(), created.getName());
//        verify(culerRepository, times(1)).save(any(Culer.class));
//    }
//
//    @Test
//    @DisplayName("Create culer already exists")
//    void testCreateCulerAlreadyExists() {
//        CulerRequestDTO dto = getSampleCulerDTO();
//        Culer existingCuler = getSampleCuler();
//
//        when(culerRepository.findByName(dto.getName())).thenReturn(Optional.of(existingCuler));
//
//        assertThrows(AlreadyExistException.class, () -> culerService.create(dto));
//        verify(culerRepository, never()).save(any(Culer.class));
//    }
//}
