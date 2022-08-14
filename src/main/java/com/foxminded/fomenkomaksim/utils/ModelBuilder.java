package com.foxminded.fomenkomaksim.utils;

import com.foxminded.fomenkomaksim.model.Lap;
import com.foxminded.fomenkomaksim.model.Racer;
import com.foxminded.fomenkomaksim.model.TimeRecord;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class ModelBuilder {

    public static List<Racer> buildModel(List<Racer> racersList, List<TimeRecord> startAndFinishTimes) {
        Map<String, Racer> racersWithKey = racersList.stream()
                .collect(toMap(Racer::getKey, r -> r));

        List<Racer> racers = startAndFinishTimes.stream()
                .collect(groupingBy(TimeRecord::getKey))
                .entrySet().stream().map(e -> {
                    Racer localRacer = racersWithKey.get(e.getKey());
                    return new Racer(
                            localRacer.getKey(),
                            localRacer.getTeam(),
                            localRacer.getName(),
                            new Lap(e.getValue().get(0).getTime(), e.getValue().get(1).getTime()));
                })
                .collect(toList());
        return racers;
    }
}
