package kpi.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharIndependence {
    public static final double Zalpha = 1.645;//1.65
    // hi = 292,2

    public static void test(List<Integer> sequence) {
        System.out.println(calculateStatistic(sequence) + " ? 292.2");
    }

    public static double calculateStatistic(List<Integer> sequence) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            frequency.put(i, 0);
        }
        for (int element : sequence) {
            frequency.put(element, frequency.get(element) + 1);
        }
        double check = (double)sequence.size()/256;
        double result = 0;
        for (Integer elemFreq : frequency.values()) {
            result += (elemFreq - check)*(elemFreq - check)/check;
        }
        return result;
    }
}
