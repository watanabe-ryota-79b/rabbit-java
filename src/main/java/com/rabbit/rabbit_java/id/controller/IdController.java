package com.rabbit.rabbit_java.id.controller;

import com.rabbit.rabbit_java.id.dto.IdResponse;
import com.rabbit.rabbit_java.id.service.IdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id")
@RequiredArgsConstructor
public class IdController {

    private final IdService idService;

    @GetMapping
    public IdResponse getId() {
        return IdResponse.builder()
                .id(idService.generateId())
                .build();
    }
}
