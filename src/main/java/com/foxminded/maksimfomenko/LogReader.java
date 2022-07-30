package com.foxminded.maksimfomenko;

import java.io.InputStream;

public class LogReader {
    private static final String START = "start.log";
    private static final String END = "end.log";
    private static final String ABBREVIATIONS = "abbreviations.txt";


    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    public InputStream getStart() {
        return getFileFromResourceAsStream(START);
    }

    public InputStream getEnd() {
        return getFileFromResourceAsStream(END);
    }

    public InputStream getAbbreviations() {
        return getFileFromResourceAsStream(ABBREVIATIONS);
    }

}