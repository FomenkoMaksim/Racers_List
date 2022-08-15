package com.foxminded.fomenkomaksim.mapper;

import com.foxminded.fomenkomaksim.model.Racer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacerMapperTest {
    @Test
    void shouldParse() {
        Racer expected = new Racer("VBM", "MERCEDES", "Valtteri Bottas", null);
        Racer actual = new RacerMapper().apply("VBM_Valtteri Bottas_MERCEDES");
        assertEquals(expected, actual);

    }
}