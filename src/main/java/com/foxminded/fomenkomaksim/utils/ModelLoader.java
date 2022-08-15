package com.foxminded.fomenkomaksim.utils;

import com.foxminded.fomenkomaksim.mapper.RacerMapper;
import com.foxminded.fomenkomaksim.mapper.TimeRecordMapper;
import com.foxminded.fomenkomaksim.model.Racer;
import com.foxminded.fomenkomaksim.model.TimeRecord;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ModelLoader {
    private static <T> List<T> loadAndParseData(Function<String, T> mapper, String filename) throws URISyntaxException, IOException {
        return ModelLoader.parse(FileUtils.readTextFromResources(filename), mapper);
    }

    private static <T> List<T> parse(List<String> source, Function<String, T> mapper) {
        return source.stream().map(mapper).collect(Collectors.toList());
    }

    public static List<Racer> loadRacerModel(String racerRecordsFileName) throws URISyntaxException, IOException {
        return loadAndParseData(new RacerMapper(), racerRecordsFileName);
    }

    public static List<TimeRecord> loadTimeRecordModel(String startTimeRecordsFileName,
                                                       String finishTimeRecordsFileName) throws URISyntaxException, IOException {
        Comparator<TimeRecord> timeRecordComparator = Comparator.comparing(TimeRecord::getKey).thenComparing(TimeRecord::getTime);

        return Stream.concat(
                        loadAndParseData(new TimeRecordMapper(), startTimeRecordsFileName).stream(),
                        loadAndParseData(new TimeRecordMapper(), finishTimeRecordsFileName).stream()
                )
                .sorted(timeRecordComparator)
                .collect(toList());
    }

}
