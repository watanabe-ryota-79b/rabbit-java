package com.rabbit.rabbit_java.id.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IdServiceTest {

    private final IdService idService = new IdService();

    @Test
    void generateId_returnsNonNullId() {
        String id = idService.generateId();
        assertThat(id).isNotNull();
    }

    @Test
    void generateId_returnsUuidFormat() {
        String id = idService.generateId();
        assertThat(id).matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
    }

    @Test
    void generateId_returnsUniqueIds() {
        String id1 = idService.generateId();
        String id2 = idService.generateId();
        assertThat(id1).isNotEqualTo(id2);
    }
}
