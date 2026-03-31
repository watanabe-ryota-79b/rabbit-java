package com.rabbit.rabbit_java.controller;

import com.rabbit.rabbit_java.dto.Pack2Response;
import com.rabbit.rabbit_java.service.Pack2Service;
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

class Pack2ControllerTest {

    @Mock
    private Pack2Service pack2Service;

    @InjectMocks
    private Pack2Controller pack2Controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pack2Controller).build();
    }

    @Test
    void addOne_returns200WithResult() throws Exception {
        when(pack2Service.addOne(5)).thenReturn(
                Pack2Response.builder().result(6).build()
        );

        mockMvc.perform(get("/pack2").param("value", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6));
    }

    @Test
    void addOne_returns400WhenValueIsNull() throws Exception {
        mockMvc.perform(get("/pack2"))
                .andExpect(status().isBadRequest());
    }
}
