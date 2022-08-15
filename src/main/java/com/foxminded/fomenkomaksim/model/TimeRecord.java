package com.foxminded.fomenkomaksim.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeRecord {
    private final String key;
    private final LocalDateTime time;

    public TimeRecord(String key, LocalDateTime time) {
        this.key = key;
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeRecord that = (TimeRecord) o;
        return Objects.equals(key, that.key) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, time);
    }

    @Override
    public String toString() {
        return "TimeRecord{" +
                "key='" + key + '\'' +
                ", time=" + time +
                '}';
    }
}
