package com.example.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    public static List<String> readTextFromResources(String filename) throws URISyntaxException, IOException {
        URL url = FileUtils.class.getResource(filename);
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return lines;
    }


}
