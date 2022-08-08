package com.foxminded.maksimfomenko;

import java.util.*;

public class TimeCalculator extends Sorter {
    public Map<String, String> lapTime(Map<String, String> startMap, Map<String, String> endMap) {

        Map<String, String> temp = new HashMap<>();

        for (Map.Entry<String, String> entry : startMap.entrySet()) {
            if (endMap.containsKey(entry.getKey())) {
                double secDiff =  timeInSeconds(endMap.get(entry.getKey())) - timeInSeconds(startMap.get(entry.getKey()));
                temp.put(entry.getKey(), secondsToStringTime(secDiff));
            }
        }

        return temp;
    }

    private double timeInSeconds(String time) {
        String[] partTime = time.split(":");
        return  (Double.parseDouble(partTime[0]) * 60 + Double.parseDouble(partTime[1])) * 60 + Double.parseDouble(partTime[2]);
    }

    public String secondsToStringTime(double timeInSec) {
        StringBuilder sb = new StringBuilder();
        int hours;
        int minutes;
        double seconds;

        hours = (int) timeInSec / 60 / 60;
        minutes = (int) timeInSec / 60 % 60;
        seconds = timeInSec % 60;

        if (hours == 0) {
            sb.append("00:");
        } else if (hours < 10 ){
            sb.append(String.format("0%s:", hours));
        } else {
            sb.append(hours).append(":");
        }

        if (minutes == 0) {
            sb.append("00:");
        } else if (minutes < 10){
            sb.append(String.format("0%s:", minutes));
        } else {
            sb.append(minutes).append(":");
        }

        if ((int)seconds < 10) {
            sb.append("0").append(String.format("%.3f", seconds).replace(",", "."));
        } else if ((int) seconds > 9){
            sb.append(String.format("%.3f", seconds).replace(",", "."));
        } else {
            sb.append(String.format("%.3f", seconds));
        }

        return sb.toString();
    }
}
