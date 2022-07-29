package com.foxminded.maksimfomenko;

import java.io.IOException;
import java.util.Map;

public class Formatter {
    private final CalculatorTime calcTime = new CalculatorTime();
    private final RacersList racersList = new RacersList();
    private final StringBuilder sb = new StringBuilder();

    private final Map<String, String[]> fullNameRacers = racersList.getAllRacersFullName();
    private int num = 0;

    public Formatter() throws IOException {
    }

    public String format() {
        calcTime.sortedMap.keySet().forEach(key -> {
            num++;
            String[] tempArr = fullNameRacers.get(key);

            if (num == 15) {
                sb.append("---------------------------------------------------------------")
                        .append("\n");
            }
            sb.append(String.format("%-2s. ", num))
                    .append(String.format("%-17s", tempArr[0]))
                    .append("| ")
                    .append(String.format("%-25s", tempArr[1]))
                    .append("| ")
                    .append(calcTime.secondsToStringTime(calcTime.sortedMap.get(key)))
                    .append("\n");
        });
        return sb.toString();
    }
}
