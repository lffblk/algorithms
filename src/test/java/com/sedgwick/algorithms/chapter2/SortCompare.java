package com.sedgwick.algorithms.chapter2;

import com.sedgwick.algorithms.chapter2.section1.InsertionSort;
import com.sedgwick.algorithms.chapter2.section1.SelectionSort;
import com.sedgwick.algorithms.chapter2.section1.ShellSort;
import com.sedgwick.algorithms.libs.StdOut;
import com.sedgwick.algorithms.libs.StdRandom;
import com.sedgwick.algorithms.libs.Stopwatch;
import org.junit.Test;

import java.util.Arrays;

public class SortCompare {

    @Test
    public void selectionSortVsInsertionSort() {
        doSort(new SelectionSort<>(), new InsertionSort<>());
    }

    @Test
    public void insertionSortVsShellSort() {
        doSort(new InsertionSort<>(), new ShellSort<>());
    }

    private void doSort(Sort<Double> sorter1, Sort<Double> sorter2) {
        int arrayLength = 10000;
        int experimentsCount = 100;

        double sortTime1 = 0.0;
        double sortTime2 = 0.0;

        for (int i = 0; i < experimentsCount; i++) {
            Double[] array = new Double[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                array[j] = StdRandom.uniform();
            }
            sortTime1 += calculateSortingTime(sorter1, Arrays.copyOf(array, array.length));
            sortTime2 += calculateSortingTime(sorter2, Arrays.copyOf(array, array.length));
        }

        StdOut.println("sortTime1 = " + sortTime1);
        StdOut.println("sortTime2 = " + sortTime2);

        String sort1Name = sorter1.getClass().getName().substring(sorter1.getClass().getName().lastIndexOf('.') + 1);
        String sort2Name = sorter2.getClass().getName().substring(sorter2.getClass().getName().lastIndexOf('.') + 1);

        StdOut.printf("For %d random numbers %s %.1f times faster than %s", arrayLength, sort2Name,
                sortTime1/sortTime2, sort1Name);
    }

    private double calculateSortingTime(Sort<Double> sorter, Double[] array) {
        Stopwatch timer = new Stopwatch();
        sorter.sort(array);
        return timer.elapsedTime();
    }
}
