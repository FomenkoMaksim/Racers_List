package com.foxminded.fomenkomaksim.utils;

import com.foxminded.fomenkomaksim.model.Lap;
import com.foxminded.fomenkomaksim.model.Racer;
import com.foxminded.fomenkomaksim.model.TimeRecord;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelBuilderTest {
    String SVF_TimeStart = "2018-05-24_12:02:58.917";
    String SVF_TimeEnd = "2018-05-24_12:04:03.332";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    LocalDateTime localStartSVF = LocalDateTime.parse(SVF_TimeStart, formatter);
    LocalDateTime localEndSVF = LocalDateTime.parse(SVF_TimeEnd, formatter);

    Racer racer1 = new Racer("SVF", "FERRARI", "Sebastian Vettel", null);

    TimeRecord time1 = new TimeRecord("SVF", localStartSVF);
    TimeRecord time2 = new TimeRecord("SVF", localEndSVF);

    @Test
    void buildModel() {
        List<Racer> racers = new ArrayList<>();
        racers.add(racer1);

        List<TimeRecord> times = new ArrayList<>();
        times.add(time1);
        times.add(time2);

        Lap lap1 = new Lap(localStartSVF, localEndSVF);

        List<Racer> actualRacerList = ModelBuilder.buildModel(racers, times);

        List<Racer> expectedRacerList = new ArrayList<>();
        expectedRacerList.add(new Racer("SVF", "FERRARI", "Sebastian Vettel", lap1));

        assertEquals(expectedRacerList, actualRacerList);
    }
}