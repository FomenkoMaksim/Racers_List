package com.foxminded.maksimfomenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacersList {
    LogReader lr = new LogReader();

    private final List<String> startLogToList = streamToList(lr.getStart());
    private final List<String> endLogToList = streamToList(lr.getEnd());
    private final List<String> allRacers = streamToList(lr.getAbbreviations());


    private List<String> streamToList(InputStream is) {
        List<String> temp = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                temp.add(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temp;
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
