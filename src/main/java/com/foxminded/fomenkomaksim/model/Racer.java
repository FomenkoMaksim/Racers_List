package com.foxminded.fomenkomaksim.model;

import java.util.Objects;

public class Racer {
    private final String key;
    private final String team;
    private final String name;
    private final Lap lap;

    public Racer(String key, String team, String name, Lap lap) {
        this.key = key;
        this.team = team;
        this.name = name;
        this.lap = lap;
    }

    public String getKey() {
        return key;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public Lap getLap() {
        return lap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racer racer = (Racer) o;
        return Objects.equals(key, racer.key) && Objects.equals(team, racer.team) && Objects.equals(name, racer.name) && Objects.equals(lap, racer.lap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, team, name, lap);
    }

    @Override
    public String toString() {
        return "Racer{" +
                "key='" + key + '\'' +
                ", team='" + team + '\'' +
                ", name='" + name + '\'' +
                ", lap=" + lap +
                '}';
    }
}
