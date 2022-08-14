package com.foxminded.fomenkomaksim.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lap {
    private final LocalDateTime start;
    private final LocalDateTime finish;

    public Lap(LocalDateTime start, LocalDateTime finish) {
        this.start = start;
        this.finish = finish;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    @Override
    public String toString() {
        return "Lap{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lap lap = (Lap) o;
        return Objects.equals(start, lap.start) && Objects.equals(finish, lap.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish);
    }
}
