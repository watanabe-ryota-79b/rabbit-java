package com.rabbit.rabbit_java.pack3.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pack3Request {
    @NotNull
    @Max(100)
    private Long value;
}
