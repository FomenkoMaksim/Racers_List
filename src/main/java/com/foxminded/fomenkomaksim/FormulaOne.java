package com.foxminded.fomenkomaksim;

import com.foxminded.fomenkomaksim.model.Racer;
import com.foxminded.fomenkomaksim.model.TimeRecord;
import com.foxminded.fomenkomaksim.utils.ModelLoader;
import com.foxminded.fomenkomaksim.utils.ModelBuilder;
import com.foxminded.fomenkomaksim.utils.TableBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

import static com.foxminded.fomenkomaksim.utils.ModelUtils.lapDuration;

public class FormulaOne {
    private void run() throws URISyntaxException, IOException {
        String racerRecordsFileName = "/abbreviations.txt";
        String startTimeRecordsFileName = "/start.log";
        String finishTimeRecordsFileName = "/end.log";

        List<Racer> racersRaw = ModelLoader.loadRacerModel(racerRecordsFileName);
        List<TimeRecord> timeRecords = ModelLoader.loadTimeRecordModel(startTimeRecordsFileName, finishTimeRecordsFileName);

        List<Racer> racers = ModelBuilder.buildModel(racersRaw, timeRecords);


        String table = TableBuilder.buildTable(racers, Comparator.comparing(r -> lapDuration.apply(r)));

        System.out.println(table);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        new FormulaOne().run();
    }
}

