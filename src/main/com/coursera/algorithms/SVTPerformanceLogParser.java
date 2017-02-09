package com.coursera.algorithms;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SVTPerformanceLogParser {
    private static final String FILE_NAME = "D://MSUP_60.log";

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        try {
            Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        calculateStatistic(getTimeOfExecution(lines));
    }

    /**
     * Get time of execution of each MSUP task from log lines
     * @param lines - collection of strings in log file
     * @return collection of Integers containing time of execution of each MSUP task
     */
    private static List<Integer> getTimeOfExecution(List<String> lines) {
        List<Integer> timeOfExecution = new ArrayList<>();
        lines.stream()
                .filter(line -> line.contains("duration="))
                .forEach(line -> {
                    String durationValue = line.substring(line.lastIndexOf("=") + 1, line.length());
                    timeOfExecution.add(Integer.parseInt(durationValue));
                });
        System.out.println("timeOfExecution = " + timeOfExecution);
        return timeOfExecution;
    }

    /**
     * Calculate the following metrics:
     * 1. Count of Orders
     * 2. Max time of execution
     * 3. Min time of execution
     * 4. Average time of execution
     * 5. 90% line
     * @param timeOfExecution - time of execution of each MSUP task from log lines
     */
    private static void calculateStatistic(List<Integer> timeOfExecution) {
        // 1. Count of Orders
        System.out.println("Processed MSUP tasks count = " + timeOfExecution.size());

        // 2. Max time of execution
        System.out.println("Max time of execution = " + Collections.max(timeOfExecution) + " ms");

        // 3. Min time of execution
        System.out.println("Min time of execution = " + Collections.min(timeOfExecution) + " ms");

        // 4. Average time of execution
        OptionalDouble average = timeOfExecution.stream().mapToInt(Integer::new).average();
        System.out.println("Average time of execution = " + average.getAsDouble() + " ms");

        // 5. 90% line
        Collections.sort(timeOfExecution);
        System.out.println("90% line = " + timeOfExecution.get(timeOfExecution.size()*9/10) + " ms");
    }
}
