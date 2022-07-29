package com.foxminded.maksimfomenko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LogReader {
    private final Stream<String> start;
    private final Stream<String> end;
    private final Stream<String> abbreviations;

    public LogReader() throws IOException {
        this.start = Files.lines(Paths.get("C:\\Java\\workspace\\task-6\\src\\main\\resources\\start.log"));
        this.end = Files.lines(Paths.get("C:\\Java\\workspace\\task-6\\src\\main\\resources\\end.log"));
        this.abbreviations = Files.lines(Paths.get("C:\\Java\\workspace\\task-6\\src\\main\\resources\\abbreviations.txt"));
    }

    public Stream<String> getStart() {
        return start;
    }

    public Stream<String> getEnd() {
        return end;
    }

    public Stream<String> getAbbreviations() {
        return abbreviations;
    }

}