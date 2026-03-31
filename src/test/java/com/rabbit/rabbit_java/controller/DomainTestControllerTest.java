package com.rabbit.rabbit_java.controller;

import com.rabbit.rabbit_java.dto.DomainTestResponse;
import com.rabbit.rabbit_java.service.DomainTestService;
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

class DomainTestControllerTest {

    @Mock
    private DomainTestService domainTestService;

    @InjectMocks
    private DomainTestController domainTestController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(domainTestController).build();
    }

    @Test
    void getDomainTest_returns200() throws Exception {
        when(domainTestService.getDomainTest()).thenReturn(
                DomainTestResponse.builder().message("Hello from DomainTest").build()
        );

        mockMvc.perform(get("/domain-test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello from DomainTest"));
    }
}
