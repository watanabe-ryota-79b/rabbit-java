package com.rabbit.rabbit_java.service;

import com.rabbit.rabbit_java.dto.PackageResponse;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    public PackageResponse addOne(long value) {
        return PackageResponse.builder().result(value + 1).build();
    }
}
