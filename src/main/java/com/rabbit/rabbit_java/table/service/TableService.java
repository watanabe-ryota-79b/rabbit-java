package com.rabbit.rabbit_java.table.service;

import com.rabbit.rabbit_java.table.dto.TableResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private static final String NAME_PREFIX = "Item-";
    private static final long MAX_TABLES = 1000;

    public List<TableResponse> getTables(long count) {
        if (count <= 0) {
            return List.of();
        }
        long limit = Math.min(count, MAX_TABLES);
        return java.util.stream.LongStream.rangeClosed(1, limit)
                .mapToObj(i -> TableResponse.builder().id(i).name(NAME_PREFIX + i).build())
                .toList();
    }
}
