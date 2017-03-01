package com;

public interface StressTestSuit {
    void run();
    void generateArguments();
    Object getResultSlow();
    Object getResultFast();
    String generateExceptionMessage(Object slowResult, Object fastResult);
}
