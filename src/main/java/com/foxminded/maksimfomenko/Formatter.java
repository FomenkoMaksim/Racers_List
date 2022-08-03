package com.foxminded.maksimfomenko;

import java.util.Map;

public class Formatter {
    private final InterfaceTime racersList = new RacersList();
    private final InterfaceCalcTime calcTime = new TimeCalculator();
    private final InterfaceSorter<String, Double> sortedTime = new ResultSorter();
    private final StringBuilder sb = new StringBuilder();

    private final Map<String, String[]> fullNameRacers = racersList.getAllRacersFullName();
    private int num = 0;

    public String format() {
        sortedTime.sort(calcTime.timeLap()).keySet().forEach(key -> {
            num++;
            String[] tempArr = fullNameRacers.get(key);

            if (num == 15) {
                sb.append("-".repeat(62))
                        .append("\n");
            }
            sb.append(String.format("%-2s. ", num))
                    .append(String.format("%-17s", tempArr[0]))
                    .append("| ")
                    .append(String.format("%-25s", tempArr[1]))
                    .append("| ")
                    .append(calcTime.secondsToStringTime(sortedTime.sort(calcTime.timeLap()).get(key)))
                    .append("\n");
        });
        return sb.toString();
    }
}
