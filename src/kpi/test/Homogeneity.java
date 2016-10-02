package kpi.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homogeneity extends Test {
    private int r;

    public Homogeneity(int r) {
        this.r = r;
        this.l = 255*(r - 1);
    }

    @Override
    public double calculateStatistic(List<Integer> sequence) {
        return calculateStatistic(sequence, r);
    }

    public double calculateStatistic(List<Integer> sequence, int r) {
        int m1 = sequence.size() / r;
        Map<Integer, Map<Integer, Integer>> rFrequency = new HashMap<>();
        for (int i = 0; i < r; i++) {
            rFrequency.put(i, calculateRStatistic(sequence, r, i));
        }
        Map<Integer, Integer> generalFrequency = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            generalFrequency.put(i, 0);
        }
        for (int j = 0; j < r; j++) {
            for (int i = 0; i < 256; i++) {
                generalFrequency.put(i, generalFrequency.get(i) + rFrequency.get(j).get(i));
            }
        }
        double sum = 0;
        for (int j = 0; j < 256; j++) {
            double sumForJ = 0;
            if(generalFrequency.get(j)==0) {
                continue;
            }
            for (int i = 0; i < r; i++) {
                int value = rFrequency.get(i).get(j);
                sumForJ += value*value;
            }
            sum += sumForJ / generalFrequency.get(j);
        }

        double result = m1*r * (sum/m1 - 1);
        return result;
    }

    private Map<Integer,Integer> calculateRStatistic(List<Integer> sequence, int r, int ind) {
        int m1 = sequence.size() / r;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            frequency.put(i, 0);
        }
        int tempInd;
        for (int i = ind*m1; i < (ind+1)*m1; i++) {
            tempInd = sequence.get(i);
            frequency.put(tempInd, frequency.get(tempInd) + 1);
        }
        return frequency;
    }

    public void setR(int r) {
        this.r = r;
        this.l = 255*(r - 1);
    }
}
