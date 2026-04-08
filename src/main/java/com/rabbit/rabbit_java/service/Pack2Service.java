package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.Pack2Response;
import org.springframework.stereotype.Service;

@Service
public class Pack2Service {

    public Pack2Response addOne(long value) {
        return Pack2Response.builder().result(value + 1).build();
    }
}
