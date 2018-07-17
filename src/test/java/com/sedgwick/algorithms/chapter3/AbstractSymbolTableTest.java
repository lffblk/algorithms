package com.sedgwick.algorithms.chapter3;

import com.google.common.collect.Maps;
import com.sedgwick.algorithms.libs.In;
import com.sedgwick.algorithms.libs.StdOut;
import com.sedgwick.algorithms.libs.Stopwatch;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractSymbolTableTest {

    protected SymbolTable<String, Integer> table;

    @Before
    public abstract void init();

    @Test
    public void testSymbolTable() {
        String[] array = {"S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E"};
        StdOut.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            String key = array[i];
            table.put(key, i);
        }

        Map<String, Integer> etalonMap = createEtalonMap();
        testEquals(etalonMap);

        etalonMap.remove("E");
        etalonMap.remove("L");

        table.delete("E");
        table.delete("L");
        testEquals(etalonMap);
    }

    @Test
    public void tinyFrequencyCounter() {
        frequencyCounter("tinyTale.txt", 6, "season", 2);
    }

    @Test
    public void mediumFrequencyCounter() {
        frequencyCounter("tale.txt", 8, "business", 122);
    }

    private void testEquals(Map<String, Integer> etalonMap) {
        for (String key : table.keys()) {
            Integer value = table.get(key);
            StdOut.println(key + " = " + value);
            assertEquals(etalonMap.get(key), value);
        }
        StdOut.print("\n");
    }

    protected void frequencyCounter(String filename, int minLen, String expectedWord, int expectedFrequency) {
        Stopwatch stopwatch = new Stopwatch();
        In in = new In("./" + filename);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() < minLen) {
                continue;
            }
            if (!table.contains(word)) {
                table.put(word, 1);
            }
            else {
                table.put(word, table.get(word) + 1);
            }
        }

        String max = "";
        table.put(max, 0);

        for (String word : table.keys()) {
            if (table.get(word) > table.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " = " + table.get(max));
        StdOut.println("time: " + stopwatch.elapsedTime() + " s\n");
        assertEquals(expectedWord, max);
        assertTrue(expectedFrequency == table.get(max));
    }

    private Map<String, Integer> createEtalonMap() {
        Map<String, Integer> etalonMap = Maps.newHashMap();

        etalonMap.put("S", 0);
        etalonMap.put("E", 12);
        etalonMap.put("A", 8);
        etalonMap.put("R", 3);
        etalonMap.put("C", 4);
        etalonMap.put("H", 5);
        etalonMap.put("X", 7);
        etalonMap.put("M", 9);
        etalonMap.put("P", 10);
        etalonMap.put("L", 11);

        return etalonMap;
    }
}
