package com.example.utils;

import com.example.model.Racer;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.utils.ModelUtils.durationFormatter;
import static com.example.utils.ModelUtils.lapDuration;
import static java.util.stream.Collectors.joining;

public class TableBuilder {
    public static String buildTable(List<Racer> racers, Comparator<Racer> tableComparator) {
        AtomicInteger counter = new AtomicInteger();

        String table = racers.stream()
                .sorted(tableComparator)
                .map(r -> String.format("%-2d. | %-30s | %-30s | %s",
                        counter.incrementAndGet(),
                        r.getName(),
                        r.getTeam(),
                        lapDuration.andThen(durationFormatter).apply(r)))
                .map(line -> counter.get() != 15 ? line : (line + "\n--------"))
                .collect(joining("\n"));
        return table;
    }
}
