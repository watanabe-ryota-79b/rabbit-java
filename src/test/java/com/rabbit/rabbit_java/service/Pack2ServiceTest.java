package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.Pack2Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Pack2ServiceTest {

    private final Pack2Service pack2Service = new Pack2Service();

    @Test
    void addOne_returnsValuePlusOne() {
        Pack2Response result = pack2Service.addOne(5);
        assertThat(result.getResult()).isEqualTo(6);
    }

    @Test
    void addOne_returnsValuePlusOneForZero() {
        Pack2Response result = pack2Service.addOne(0);
        assertThat(result.getResult()).isEqualTo(1);
    }

    @Test
    void addOne_returnsValuePlusOneForNegative() {
        Pack2Response result = pack2Service.addOne(-1);
        assertThat(result.getResult()).isEqualTo(0);
    }
}
