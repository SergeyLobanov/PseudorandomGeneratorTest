package kpi.generator.l89;

import kpi.util.*;

public class L89Main {

    public static void main(String[] args) {
        BigInitializer init89 = new BigInitializer(89, 51);
        BigLFSR lfsr89 = new BigLFSR(init89);
        lfsr89.setInitialState(1);
//        lfsr89.shift(150);
//        System.out.println(lfsr89.getOutputSequence());
//        System.out.println(lfsr89.getBytesOutput());
        System.out.println(lfsr89.generateMBytes(100));
    }
}
