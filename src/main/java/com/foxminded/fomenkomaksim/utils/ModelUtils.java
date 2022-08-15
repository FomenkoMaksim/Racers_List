package com.foxminded.fomenkomaksim.utils;

import com.foxminded.fomenkomaksim.model.Racer;

import java.time.Duration;
import java.util.function.Function;

public class ModelUtils {
    public static final Function<Racer, Duration> lapDuration = racer -> Duration.between(racer.getLap().getStart(), racer.getLap().getFinish());

    public static final Function<Duration, String> durationFormatter = duration -> String.format("%-2d:%02d.%03d",
            duration.toMinutes(),
            duration.toSecondsPart(),
            duration.toMillisPart());

}
