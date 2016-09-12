package kpi.generator.l89;

import kpi.util.Initializer;
import kpi.util.LFSR;

public class L89Main {

    public static void main(String[] args) {
        Initializer init89 = new Initializer(89, 51);
        LFSR lfsr89 = new LFSR(init89);
        lfsr89.setInitialState(1);
        lfsr89.shift(150);
        System.out.println(lfsr89.getOutputSequence());
    }
}
