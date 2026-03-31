package com.rabbit.rabbit_java.table.service;

import com.rabbit.rabbit_java.table.dto.TableResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TableServiceTest {

    private final TableService tableService = new TableService();

    @Test
    void getTables_returnsListWithSpecifiedCount() {
        List<TableResponse> result = tableService.getTables(3);
        assertThat(result).hasSize(3);
    }

    @Test
    void getTables_eachItemHasIdAndName() {
        List<TableResponse> result = tableService.getTables(3);
        result.forEach(item -> {
            assertThat(item.getId()).isPositive();
            assertThat(item.getName()).isNotBlank();
        });
    }

    @Test
    void getTables_returnsEmptyListWhenCountIsZero() {
        List<TableResponse> result = tableService.getTables(0);
        assertThat(result).isEmpty();
    }

    @Test
    void getTables_returnsExactIdAndName() {
        List<TableResponse> result = tableService.getTables(3);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getName()).isEqualTo("Item-1");
        assertThat(result.get(2).getId()).isEqualTo(3L);
        assertThat(result.get(2).getName()).isEqualTo("Item-3");
    }
}
