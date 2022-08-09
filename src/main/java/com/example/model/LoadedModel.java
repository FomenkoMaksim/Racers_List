package com.example.model;

import java.util.List;
import java.util.Objects;

public class LoadedModel {
    private final List<Racer> racersList;
    private final List<TimeRecord> startAndFinishTimes;

    public LoadedModel(List<Racer> racersList, List<TimeRecord> startAndFinishTimes) {

        this.racersList = racersList;
        this.startAndFinishTimes = startAndFinishTimes;
    }

    public List<Racer> getRacersList() {
        return racersList;
    }

    public List<TimeRecord> getStartAndFinishTimes() {
        return startAndFinishTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadedModel that = (LoadedModel) o;
        return Objects.equals(racersList, that.racersList) && Objects.equals(startAndFinishTimes, that.startAndFinishTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racersList, startAndFinishTimes);
    }
}
