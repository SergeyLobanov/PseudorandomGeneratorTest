package kpi.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharIndependence extends Test {

    public CharIndependence() {
        this.l = 255*255;
    }

    public double calculateStatistic(List<Integer> sequence) {
        Map<Integer, Integer> frequency = new HashMap<>();
        // init
        for (int i = 0; i < 256*256; i++) {
            frequency.put(i, 0);
        }
        // count statistics
        for (int i = 0; i < sequence.size() - 1; i+=2) {
            int ind = sequence.get(i)+sequence.get(i+1)*256;
            frequency.put(ind, (frequency.get(ind) + 1));
        }
        // count stat for first byte
        Map<Integer, Integer> firstByteCounts = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            firstByteCounts.put(i, firstByteAppearInPairs(frequency, i));
        }
        // count stat for second byte
        Map<Integer, Integer> secondByteCounts = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            secondByteCounts.put(i, secondByteAppearInPairs(frequency, i));
        }
        // count frequency
        double sum = 0;
        for(int j = 0; j < 255; j++) {
            double sumByFirstByte = 0;
            for(int i = 0; i < frequency.size(); i++) {
                if(frequency.get(i)==0) {
                    continue;
                }
                if(i%256 == j) {
                    sumByFirstByte += ((double)frequency.get(i)*frequency.get(i))
                    / (double)secondByteCounts.get(i/256);
                }
            }
            if (sumByFirstByte == Double.NaN || sumByFirstByte == 0) {
                continue;
            }
            sum += sumByFirstByte / firstByteCounts.get(j);
        }

        int n = sequence.size()/2;
        double result = n*(sum - 1);

        return Double.valueOf(result).intValue();
    }

    public int firstByteAppearInPairs(Map<Integer, Integer> frequency, int byteValue) {
        int count = 0;
        for (int i = byteValue; i < frequency.size(); i += 256) {
            count += frequency.get(i);
        }
        return count;
    }

    public int secondByteAppearInPairs(Map<Integer, Integer> frequency, int byteValue) {
        int count = 0;
        for (int i = byteValue*256; i < byteValue*256 + 256; i++) {
            count += frequency.get(i);
        }
        return count;
    }
}
