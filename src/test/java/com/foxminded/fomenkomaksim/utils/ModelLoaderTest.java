package com.foxminded.fomenkomaksim.utils;

import com.foxminded.fomenkomaksim.model.Racer;
import com.foxminded.fomenkomaksim.model.TimeRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelLoaderTest {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");


    @Test
    void shouldLoadRacerModel() throws URISyntaxException, IOException {
        List<Racer> expected = Arrays.asList(
                new Racer("Key1", "Team1", "Name1", null),
                new Racer("Key2", "Team2", "Name2", null),
                new Racer("Key3", "Team3", "Name3", null)
        );

        List<Racer> actual = ModelLoader.loadRacerModel("/racers.txt");

        assertEquals(expected, actual);
    }

    @Test
    void shouldLoadTimeRecordModel() throws URISyntaxException, IOException {

        List<TimeRecord> expected = Arrays.asList(
                new TimeRecord("AAA", LocalDateTime.parse("2001-01-01_01:01:01.001", formatter)),
                new TimeRecord("AAA", LocalDateTime.parse("2001-01-01_01:10:01.001", formatter)),
                new TimeRecord("BBB", LocalDateTime.parse("2002-02-02_02:02:02.002", formatter)),
                new TimeRecord("BBB", LocalDateTime.parse("2002-02-02_02:20:02.002", formatter)),
                new TimeRecord("CCC", LocalDateTime.parse("2003-03-03_03:03:03.003", formatter)),
                new TimeRecord("CCC", LocalDateTime.parse("2003-03-03_03:30:03.003", formatter))
        );

        List<TimeRecord> actual = ModelLoader.loadTimeRecordModel("/timeStart.log", "/timeEnd.log");

        assertEquals(expected, actual);
    }
}