package com.example.mapper;

import com.example.model.TimeRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeRecordMapperTest {

    @Test
    void shouldParse() {
        TimeRecord actual = new TimeRecordMapper().apply("SVF2018-05-24_12:04:03.332");

        System.out.println(actual);
    }
}