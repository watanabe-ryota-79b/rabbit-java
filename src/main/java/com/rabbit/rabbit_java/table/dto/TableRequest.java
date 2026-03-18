package com.rabbit.rabbit_java.table.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableRequest {
    @Min(100)
    private long id;
}
