package com.foxminded.maksimfomenko;

import java.util.Map;

public class Formatter {
    private final RacersList racersList = new RacersList();
    private final TimeCalculator calcTime = new TimeCalculator(racersList);
    private final StringBuilder sb = new StringBuilder();

    private final Map<String, String[]> fullNameRacers = racersList.getAllRacersFullName();
    private int num = 0;

    public String format() {
        calcTime.sortedBestLapTime.keySet().forEach(key -> {
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
                    .append(calcTime.secondsToStringTime(calcTime.sortedBestLapTime.get(key)))
                    .append("\n");
        });
        return sb.toString();
    }
}
