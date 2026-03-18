package com.rabbit.rabbit_java.id.controller;

import com.rabbit.rabbit_java.id.service.IdService;
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

class IdControllerTest {

    @Mock
    private IdService idService;

    @InjectMocks
    private IdController idController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(idController).build();
    }

    @Test
    void getId_returns200WithId() throws Exception {
        when(idService.generateId()).thenReturn("test-id");

        mockMvc.perform(get("/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("test-id"));
    }
}
