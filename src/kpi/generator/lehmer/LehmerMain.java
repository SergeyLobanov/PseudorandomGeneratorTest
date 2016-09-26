package kpi.generator.lehmer;

import kpi.generator.lehmer.high.LehmerHigh;
import kpi.generator.lehmer.low.LehmerLow;

public class LehmerMain {

    public static void main(String[] args) {

        System.out.println("LehmerLow");
        LehmerLow lehmerLow = new LehmerLow();
//        lehmerLow.generateSequence(20);
//        System.out.println(lehmerLow.getGeneratedElements());
//        for (Integer value: lehmerLow.getGeneratedElements()) {
//            System.out.println(Long.toBinaryString(value));
//        }
        System.out.println(lehmerLow.generateMBytes(100));

        System.out.println("LehmerHigh");
        LehmerHigh lehmerHigh = new LehmerHigh();
        lehmerHigh.setX0(123123123);
//        lehmerHigh.generateSequence(20);
//        System.out.println(lehmerHigh.getGeneratedElements());
//        for (Integer value: lehmerHigh.getGeneratedElements()) {
//            System.out.println(Long.toBinaryString(value));
//        }
        System.out.println(lehmerHigh.generateMBytes(100));
    }
}
