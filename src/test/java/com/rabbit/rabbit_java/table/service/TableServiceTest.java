package com.rabbit.rabbit_java.table.service;

import com.rabbit.rabbit_java.table.dto.TableResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TableServiceTest {

    private final TableService tableService = new TableService();

    @Test
    void getTables_returnsNonEmptyList() {
        List<TableResponse> result = tableService.getTables();
        assertThat(result).isNotEmpty();
    }

    @Test
    void getTables_eachItemHasIdAndName() {
        List<TableResponse> result = tableService.getTables();
        result.forEach(item -> {
            assertThat(item.getId()).isPositive();
            assertThat(item.getName()).isNotBlank();
        });
    }
}
