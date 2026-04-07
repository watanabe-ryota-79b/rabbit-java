package com.rabbit.rabbit_java.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pack3Request {
    @NotNull
    private Long value;
}
