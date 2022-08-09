package com.example.utils;

import com.example.model.Racer;

import java.time.Duration;
import java.util.function.Function;

public class ModelUtils {
    public static Function<Racer, Duration> lapDuration = racer -> Duration.between(racer.getLap().getStart(), racer.getLap().getFinish());

    public static Function<Duration, String> durationFormatter = duration -> String.format("%-2d:%02d.%03d",
            duration.toMinutes(),
            duration.toSecondsPart(),
            duration.toMillisPart());

}
