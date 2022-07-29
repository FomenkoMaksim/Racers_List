package com.foxminded.maksimfomenko;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacersList {
    LogReader lr = new LogReader();

    private final List<String> startLogToList = lr.getStart().collect(Collectors.toList());
    private final List<String> endLogToList = lr.getEnd().collect(Collectors.toList());
    private final List<String> allRacers = lr.getAbbreviations().collect(Collectors.toList());

    public RacersList() throws IOException {
    }

    public Map<String, String[]> getAllRacersFullName() {
        Map<String, String[]> tempMap = new HashMap<>();
        for (String s : allRacers) {
            tempMap.put(s.substring(0, 3), s.substring(4).split("_"));
        }
        return tempMap;
    }

    public Map<String, String> getStartMap() {
        Map<String, String> tempMap = new HashMap<>();
        for (String s : startLogToList) {
            tempMap.put(s.substring(0, 3), s.substring(14));
        }
        return tempMap;
    }

    public Map<String, String> getEndMap() {
        Map<String, String> tempMap = new HashMap<>();
        for (String s : endLogToList) {
            tempMap.put(s.substring(0, 3), s.substring(14));
        }
        return tempMap;
    }
}
