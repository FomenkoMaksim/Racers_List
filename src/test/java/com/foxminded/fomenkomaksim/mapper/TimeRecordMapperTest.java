package com.foxminded.fomenkomaksim.mapper;

import com.foxminded.fomenkomaksim.model.TimeRecord;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TimeRecordMapperTest {

    @Test
    void shouldParse() {
        String str = "2018-05-24_12:04:03.332";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        TimeRecord actual = new TimeRecordMapper().apply("SVF2018-05-24_12:04:03.332");
        TimeRecord expected  = new TimeRecord("SVF", dateTime);

        assertEquals(expected, actual);
    }
}