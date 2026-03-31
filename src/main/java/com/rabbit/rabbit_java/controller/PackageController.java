package com.rabbit.rabbit_java.controller;

import com.rabbit.rabbit_java.dto.PackageRequest;
import com.rabbit.rabbit_java.dto.PackageResponse;
import com.rabbit.rabbit_java.service.PackageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")
@RequiredArgsConstructor
public class PackageController {

    private final PackageService packageService;

    @GetMapping
    public ResponseEntity<PackageResponse> addOne(
            @Valid @ModelAttribute PackageRequest request,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(packageService.addOne(request.getValue()));
    }
}
