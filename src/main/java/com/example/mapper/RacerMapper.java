package com.example.mapper;

import com.example.model.Racer;

import java.util.function.Function;

public class RacerMapper implements Function<String, Racer> {
    @Override
    public Racer apply(String s) {
        // VBM_Valtteri Bottas_MERCEDES
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
