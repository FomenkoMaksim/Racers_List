package com.foxminded.fomenkomaksim.utils;

import com.foxminded.fomenkomaksim.model.Lap;
import com.foxminded.fomenkomaksim.model.Racer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TableBuilderTest {
    private final String SVF_TimeStart = "2018-05-24_12:02:58.917";
    private final String SVF_TimeEnd = "2018-05-24_12:04:03.332";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    LocalDateTime localStartSVF = LocalDateTime.parse(SVF_TimeStart, formatter);
    LocalDateTime localEndSVF = LocalDateTime.parse(SVF_TimeEnd, formatter);
    Lap lap1 = new Lap(localStartSVF, localEndSVF);

    Comparator<Racer> comparator = Comparator.comparing(Racer::getName);


    @Test
    void shouldBuildTable() {
        List<Racer> racerList = Arrays.asList(
                new Racer("AAA", "A", "AA", lap1),
                new Racer("BBB", "B", "BB", lap1),
                new Racer("CCC", "C", "CC", lap1)
                );

        String expected =
                "1 . | AA                             | A                              | 1 :04.415\n" +
                "2 . | BB                             | B                              | 1 :04.415\n" +
                "3 . | CC                             | C                              | 1 :04.415";

        String actual =  TableBuilder.buildTable(racerList, comparator);

        assertEquals(expected, actual);
    }
}