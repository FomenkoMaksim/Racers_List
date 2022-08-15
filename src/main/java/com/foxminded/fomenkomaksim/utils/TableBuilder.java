package com.foxminded.fomenkomaksim.utils;

import com.foxminded.fomenkomaksim.model.Racer;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.foxminded.fomenkomaksim.utils.ModelUtils.durationFormatter;
import static com.foxminded.fomenkomaksim.utils.ModelUtils.lapDuration;
import static java.util.stream.Collectors.joining;

public class TableBuilder {
    public static String buildTable(List<Racer> racers, Comparator<Racer> tableComparator) {
        String dash = "-";
        AtomicInteger counter = new AtomicInteger();

        String table = racers.stream()
                .sorted(tableComparator)
                .map(r -> String.format("%-2d. | %-30s | %-30s | %s",
                        counter.incrementAndGet(),
                        r.getName(),
                        r.getTeam(),
                        lapDuration.andThen(durationFormatter).apply(r)))
                .map(line -> counter.get() != 15 ? line : (line + "\n" + dash.repeat(81)))
                .collect(joining("\n"));
        return table;
    }
}
