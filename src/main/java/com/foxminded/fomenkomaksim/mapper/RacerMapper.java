package com.foxminded.fomenkomaksim.mapper;

import com.foxminded.fomenkomaksim.model.Racer;

import java.util.function.Function;

public class RacerMapper implements Function<String, Racer> {
    @Override
    public Racer apply(String s) {
        String[] parts = s.split("_", 3);
        if (parts.length != 3) {
            throw new IllegalArgumentException("Input is corrupted");
        }

        return new Racer(
                parts[0],
                parts[2],
                parts[1],
                null
        );
    }
}
