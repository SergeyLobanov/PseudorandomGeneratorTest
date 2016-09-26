package kpi.util;

import java.util.ArrayList;
import java.util.List;

public class BitConverter {

    public static List<Integer> getBytesOutput(List<Integer> bitArray) {
        List<Integer> byteOutput = new ArrayList<>();
        int bytesInOutput = bitArray.size()/8;
        StringBuilder builder = new StringBuilder();
        // build 8 elements from bit array to string
        for (int i = 0; i < bytesInOutput*8; i++) {
            if (i % 8 == 0) {
                if(i != 0) {
                    // reverse sequential bits from array to get binary representation of byte
                    byteOutput.add(Integer.valueOf(builder.reverse().toString(), 2));
                }
                builder = new StringBuilder();
            }
            builder.append(bitArray.get(i));
        }
        return byteOutput;
    }

    public static List<Integer> getBytesListFromBitsString(String bits) {
        List<Integer> byteOutput = new ArrayList<>();
        int bytesInString = bits.length()/8;
        for (int i = 0; i < bytesInString; i++) {
            String temp = bits.substring(i*8, i*8 + 8);
            byteOutput.add(Integer.valueOf(new StringBuilder(temp).reverse().toString(), 2));
        }

        return byteOutput;
    }
}
