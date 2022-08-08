package com.foxminded.maksimfomenko;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMapper extends TimeCalculator implements TimeMapperInterface<String, String> {

    @Override
    public Map<String, String> toMap(List<String> listStart, List<String> listEnd) {

        Map<String, String> tempStart = new HashMap<>();

        for (String s : listStart) {
            tempStart.put(s.substring(0, 3), s.substring(14));
        }

        Map<String, String> tempEnd = new HashMap<>();

        for (String s : listEnd) {
            tempEnd.put(s.substring(0, 3), s.substring(14));
        }

        return lapTime(tempStart, tempEnd);
    }
}
