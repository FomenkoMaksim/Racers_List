package com.foxminded.maksimfomenko;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CalculatorTime {
    RacersList racersList = new RacersList();
    Map<String, String> bestLap = new HashMap<>();
    Map<String, Double> unsortedMap = timeLap();
    Map<String, Double> sortedMap = unsortedMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    public CalculatorTime() throws IOException {
    }


    public Map<String, Double> timeLap() {
        Map<String, Double> temp = new HashMap<>();
        for (Map.Entry<String, String> entry : racersList.getStartMap().entrySet()) {
            if (racersList.getEndMap().containsKey(entry.getKey())) {
                double secDiff =  timeInSeconds(racersList.getEndMap().get(entry.getKey())) - timeInSeconds(racersList.getStartMap().get(entry.getKey()));
                temp.put(entry.getKey(), secDiff);
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
