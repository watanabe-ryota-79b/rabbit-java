package com.rabbit.rabbit_java.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageRequest {
    @NotNull
    private Long value;
}
