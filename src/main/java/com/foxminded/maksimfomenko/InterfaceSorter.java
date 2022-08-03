package com.foxminded.maksimfomenko;

import java.util.Map;

public interface InterfaceSorter<T, R> {
    Map<T, R> sort(Map<T, R> unsortedBestLapTime);
}
