package com.foxminded.maksimfomenko;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sorter {

    public Map<String, Double> sort(Map<String, Double> unsortedBestLapTime) {
        return unsortedBestLapTime.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//    Map<String, Double> sortedBestLapTime = unsortedBestLapTime.entrySet()
//            .stream()'
//            .sorted(Map.Entry.comparingByValue())
//            .collect(Collectors.toMap(
//                    Map.Entry::getKey,
//                    Map.Entry::getValue,
//                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
