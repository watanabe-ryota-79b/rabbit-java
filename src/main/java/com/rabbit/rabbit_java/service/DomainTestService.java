package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.DomainTestResponse;
import org.springframework.stereotype.Service;

@Service
public class DomainTestService {

    private static final String FIXED_MESSAGE = "Hello from DomainTest";

    public DomainTestResponse getDomainTest() {
        return DomainTestResponse.builder().message(FIXED_MESSAGE).build();
    }
}
