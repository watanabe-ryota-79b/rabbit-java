package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.DomainTestResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DomainTestServiceTest {

    private final DomainTestService domainTestService = new DomainTestService();

    @Test
    void getDomainTest_returnsFixedMessage() {
        DomainTestResponse result = domainTestService.getDomainTest();
        assertThat(result.getMessage()).isEqualTo("Hello from DomainTest");
    }
}
