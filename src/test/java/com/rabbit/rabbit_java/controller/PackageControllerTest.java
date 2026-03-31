package com.rabbit.rabbit_java.controller;

import com.rabbit.rabbit_java.dto.PackageResponse;
import com.rabbit.rabbit_java.service.PackageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PackageControllerTest {

    @Mock
    private PackageService packageService;

    @InjectMocks
    private PackageController packageController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(packageController).build();
    }

    @Test
    void addOne_returns200WithResult() throws Exception {
        when(packageService.addOne(5)).thenReturn(
                PackageResponse.builder().result(6).build()
        );

        mockMvc.perform(get("/package").param("value", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6));
    }

    @Test
    void addOne_returns400WhenValueIsNull() throws Exception {
        mockMvc.perform(get("/package"))
                .andExpect(status().isBadRequest());
    }
}
