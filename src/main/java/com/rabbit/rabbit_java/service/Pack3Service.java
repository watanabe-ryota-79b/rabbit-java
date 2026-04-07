package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.Pack3Response;
import org.springframework.stereotype.Service;

@Service
public class Pack3Service {

    public Pack3Response addOne(long value) {
        return Pack3Response.builder().result(value + 1).build();
    }
}
