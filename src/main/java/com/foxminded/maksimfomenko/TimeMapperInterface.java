package com.foxminded.maksimfomenko;

import java.util.List;
import java.util.Map;

public interface TimeMapperInterface<T, R> {

    Map<T, R> toMap(List<String> listStart, List<String> listEnd);
}
