package com.rabbit.rabbit_java.table.service;

import com.rabbit.rabbit_java.table.dto.TableResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private static final String NAME_PREFIX = "Item-";

    public List<TableResponse> getTables(long count) {
        return java.util.stream.LongStream.rangeClosed(1, count)
                .mapToObj(i -> TableResponse.builder().id(i).name(NAME_PREFIX + i).build())
                .toList();
    }
}
