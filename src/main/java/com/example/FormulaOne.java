package com.example;

import com.example.mapper.RacerMapper;
import com.example.mapper.TimeRecordMapper;
import com.example.model.Lap;
import com.example.model.LoadedModel;
import com.example.model.Racer;
import com.example.model.TimeRecord;
import com.example.utils.FileUtils;
import com.example.utils.ModelLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.example.utils.ModelBuilder.buildModel;
import static com.example.utils.ModelUtils.lapDuration;
import static com.example.utils.TableBuilder.buildTable;
import static java.util.stream.Collectors.*;

public class FormulaOne {
    private void run() throws URISyntaxException, IOException {
        String racerRecordsFileName = "/abbreviations.txt";
        String startTimeRecordsFileName = "/start.log";
        String finishTimeRecordsFileName = "/end.log";
        List<Racer> racersRaw = ModelLoader.loadRacerModel(racerRecordsFileName);
        List<TimeRecord> timeRecords = ModelLoader.loadTimeRecordModel(startTimeRecordsFileName, finishTimeRecordsFileName);

        List<Racer> racers = buildModel(racersRaw, timeRecords);


        String table1 = buildTable(racers, Comparator.comparing(r -> lapDuration.apply(r)));

        String table2 = buildTable(racers, Comparator.comparing(Racer::getTeam));

        System.out.println(table1);

        System.out.println(table2);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        new FormulaOne().run();
    }
}

