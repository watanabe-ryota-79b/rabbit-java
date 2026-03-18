package com.rabbit.rabbit_java.table.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TableResponse {
    private long id;
    private String name;
}
