package com.rabbit.rabbit_java.controller;

import com.rabbit.rabbit_java.dto.Pack3Response;
import com.rabbit.rabbit_java.service.Pack3Service;
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

class Pack3ControllerTest {

    @Mock
    private Pack3Service pack3Service;

    @InjectMocks
    private Pack3Controller pack3Controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pack3Controller).build();
    }

    @Test
    void addOne_returns200WithResult() throws Exception {
        when(pack3Service.addOne(5)).thenReturn(
                Pack3Response.builder().result(6).build()
        );

        mockMvc.perform(get("/pack3").param("value", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6));
    }

    @Test
    void addOne_returns400WhenValueIsNull() throws Exception {
        mockMvc.perform(get("/pack3"))
                .andExpect(status().isBadRequest());
    }
}
