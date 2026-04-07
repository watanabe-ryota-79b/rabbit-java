package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.Pack3Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Pack3ServiceTest {

    private final Pack3Service pack3Service = new Pack3Service();

    @Test
    void addOne_returnsValuePlusOne() {
        Pack3Response result = pack3Service.addOne(5);
        assertThat(result.getResult()).isEqualTo(6);
    }

    @Test
    void addOne_returnsValuePlusOneForZero() {
        Pack3Response result = pack3Service.addOne(0);
        assertThat(result.getResult()).isEqualTo(1);
    }

    @Test
    void addOne_returnsValuePlusOneForNegative() {
        Pack3Response result = pack3Service.addOne(-1);
        assertThat(result.getResult()).isEqualTo(0);
    }
}
