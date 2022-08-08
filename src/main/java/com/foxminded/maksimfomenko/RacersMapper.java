package com.foxminded.maksimfomenko;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacersMapper implements  RacerMapperInterface {

    @Override
    public Map<String, String[]> toMap(List<String> list) {
        Map<String, String[]> tempMap = new HashMap<>();
        for (String s : list) {
            tempMap.put(s.substring(0, 3), s.substring(4).split("_"));
        }
        return tempMap;
    }
}
