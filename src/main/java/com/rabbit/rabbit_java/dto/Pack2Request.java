package com.rabbit.rabbit_java.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pack2Request {
    @NotNull
    private Long value;
}
