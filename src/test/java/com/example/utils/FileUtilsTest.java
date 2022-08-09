package com.example.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {
    @Test
    void shouldReadFromResources() throws URISyntaxException, IOException {
        List<String> actual = FileUtils.readTextFromResources("/read_me.txt");
        List<String> expected = Arrays.asList("1", "2", "3");
        assertEquals(expected, actual);
    }
}