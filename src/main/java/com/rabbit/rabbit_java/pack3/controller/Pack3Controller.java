package com.rabbit.rabbit_java.pack3.controller;

import com.rabbit.rabbit_java.pack3.dto.Pack3Request;
import com.rabbit.rabbit_java.pack3.dto.Pack3Response;
import com.rabbit.rabbit_java.pack3.service.Pack3Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pack3")
@RequiredArgsConstructor
public class Pack3Controller {

    private final Pack3Service pack3Service;

    @GetMapping
    public ResponseEntity<Pack3Response> addOne(
            @Valid @ModelAttribute Pack3Request request,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pack3Service.addOne(request.getValue()));
    }
}
