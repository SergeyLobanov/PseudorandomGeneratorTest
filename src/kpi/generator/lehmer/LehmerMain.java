package kpi.generator.lehmer;

import kpi.generator.lehmer.high.LehmerHigh;
import kpi.generator.lehmer.low.LehmerLow;

public class LehmerMain {

    public static void main(String[] args) {

        System.out.println("LehmerLow");
        LehmerLow lehmerLow = new LehmerLow();
        System.out.println(lehmerLow.getGeneratedSequence());
        lehmerLow.generateSequence(20);
        for (Integer value: lehmerLow.getGeneratedElements()) {
            System.out.println(Long.toBinaryString(value));
        }

        System.out.println("LehmerHigh");
        LehmerHigh lehmerHigh = new LehmerHigh();
        lehmerHigh.setX0(123123123);
        System.out.println(lehmerHigh.getGeneratedSequence());
        lehmerHigh.generateSequence(20);
        for (Integer value: lehmerHigh.getGeneratedElements()) {
            System.out.println(Long.toBinaryString(value));
        }
    }
}
