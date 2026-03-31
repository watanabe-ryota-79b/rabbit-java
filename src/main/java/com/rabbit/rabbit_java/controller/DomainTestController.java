package com.rabbit.rabbit_java.controller;

import com.rabbit.rabbit_java.dto.DomainTestResponse;
import com.rabbit.rabbit_java.service.DomainTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain-test")
@RequiredArgsConstructor
public class DomainTestController {

    private final DomainTestService domainTestService;

    @GetMapping
    public ResponseEntity<DomainTestResponse> getDomainTest() {
        return ResponseEntity.ok(domainTestService.getDomainTest());
    }
}
