package com.foxminded.maksimfomenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LogLoader implements Loader {
    private final String START;
    private final String END;
    private final String ABBREVIATIONS;

    public LogLoader(String start, String end, String abbreviations) {
        this.START = start;
        this.END = end;
        this.ABBREVIATIONS = abbreviations;
    }

    public List<String> getFileFromResourceAsList(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return streamToList(inputStream);
        }
    }

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

//    public InputStream getStart() {
//        return getFileFromResourceAsStream(START);
//    }
//
//    public InputStream getEnd() {
//        return getFileFromResourceAsStream(END);
//    }
//
//    public InputStream getAbbreviations() {
//        return getFileFromResourceAsStream(ABBREVIATIONS);
//    }

}