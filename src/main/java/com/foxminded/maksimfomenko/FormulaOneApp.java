package com.foxminded.maksimfomenko;

import java.util.List;

public class FormulaOneApp {
    private static final String START = "start.log";
    private static final String END = "end.log";
    private static final String ABBREVIATIONS = "abbreviations.txt";

    public static void main(String[] args) {
//        Formatter formatter = new Formatter();
//        System.out.println(formatter.format());

        Loader logLoader = new LogLoader(START, END, ABBREVIATIONS);
        TimeMapperInterface<String, String> timeMapper = new TimeMapper();
        RacerMapperInterface racerMapper = new RacersMapper();

        List<String> startList = logLoader.getFileFromResourceAsList(START);
        List<String> endList = logLoader.getFileFromResourceAsList(END);
        List<String> abbreviationsList = logLoader.getFileFromResourceAsList(ABBREVIATIONS);

        timeMapper.toMap(startList, endList);
        racerMapper.toMap(abbreviationsList);


        System.out.println(timeMapper.toMap(startList, endList).toString());
        System.out.println(racerMapper.toMap(abbreviationsList).toString());
//        System.out.println(startList.toString());
//        System.out.println(endList.toString());
//        System.out.println(abbreviationsList.toString());

    }
}
