package kpi.generator.l20;

import kpi.util.BitConverter;
import kpi.util.Initializer;
import kpi.util.LFSR;

public class L20Main {

    public static void main(String[] args) {
        Initializer init20 = new Initializer(20, 17, 15, 11);
        LFSR lfsr20 = new LFSR(init20);
        lfsr20.setInitialState(1);
//        lfsr20.shift(50);
//        System.out.println(lfsr20.getOutputSequence());
//        System.out.println(lfsr20.getBytesOutput());
        System.out.println(lfsr20.generateMBytes(100));
    }
}
