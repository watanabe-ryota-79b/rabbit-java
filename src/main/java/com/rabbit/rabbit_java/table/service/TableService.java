package com.rabbit.rabbit_java.table.service;

import com.rabbit.rabbit_java.table.dto.TableResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    public List<TableResponse> getTables() {
        return List.of(
                TableResponse.builder().id(1).name("Alice").build(),
                TableResponse.builder().id(2).name("Bob").build(),
                TableResponse.builder().id(3).name("Charlie").build()
        );
    }
}
