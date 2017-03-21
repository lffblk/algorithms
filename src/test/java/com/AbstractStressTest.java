package com;

public abstract class AbstractStressTest implements StressTestSuit {
    public void run(int iterationsCount) {
        Tester.test(iterationsCount, this);
    }
}
