package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.PackageResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PackageServiceTest {

    private final PackageService packageService = new PackageService();

    @Test
    void addOne_returnsValuePlusOne() {
        PackageResponse result = packageService.addOne(5);
        assertThat(result.getResult()).isEqualTo(6);
    }

    @Test
    void addOne_returnsValuePlusOneForZero() {
        PackageResponse result = packageService.addOne(0);
        assertThat(result.getResult()).isEqualTo(1);
    }

    @Test
    void addOne_returnsValuePlusOneForNegative() {
        PackageResponse result = packageService.addOne(-1);
        assertThat(result.getResult()).isEqualTo(0);
    }
}
