package com.rabbit.rabbit_java.table.controller;

import com.rabbit.rabbit_java.table.dto.TableResponse;
import com.rabbit.rabbit_java.table.service.TableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TableControllerTest {

    @Mock
    private TableService tableService;

    @InjectMocks
    private TableController tableController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tableController).build();
    }

    @Test
    void getTables_returns200WithValidId() throws Exception {
        when(tableService.getTables(100)).thenReturn(List.of(
                TableResponse.builder().id(1).name("Item-1").build()
        ));

        mockMvc.perform(get("/tables").param("id", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Item-1"));
    }

    @Test
    void getTables_returns400WhenIdIsLessThan100() throws Exception {
        mockMvc.perform(get("/tables").param("id", "99"))
                .andExpect(status().isBadRequest());
    }
}
