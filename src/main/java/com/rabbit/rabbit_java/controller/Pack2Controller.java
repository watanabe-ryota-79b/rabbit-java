package com.rabbit.rabbit_java.controller;

import com.rabbit.rabbit_java.dto.Pack2Request;
import com.rabbit.rabbit_java.dto.Pack2Response;
import com.rabbit.rabbit_java.service.Pack2Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pack2")
@RequiredArgsConstructor
public class Pack2Controller {

    private final Pack2Service pack2Service;

    @GetMapping
    public ResponseEntity<Pack2Response> addOne(
            @Valid @ModelAttribute Pack2Request request,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pack2Service.addOne(request.getValue()));
    }
}
