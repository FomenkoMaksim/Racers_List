package com.example.mapper;

import com.example.model.TimeRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class TimeRecordMapper implements Function<String, TimeRecord> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    @Override
    public TimeRecord apply(String s) {
        String str = "1986-04-08 12:30";
        String key = s.substring(0, 3);
        String timeString = s.substring(3);
        LocalDateTime parsedTime = LocalDateTime.parse(timeString, formatter);

        return new TimeRecord(key, parsedTime);

    }

}
