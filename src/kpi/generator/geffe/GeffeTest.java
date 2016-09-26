package kpi.generator.geffe;

import kpi.util.BitConverter;
import kpi.util.Initializer;
import kpi.util.LFSR;

public class GeffeTest {

    public static void main(String[] args) {

        Initializer polynom1 = new Initializer(11, 2);
        Initializer polynom2 = new Initializer(9, 4, 3, 1);
        Initializer polynom3 = new Initializer(10, 3);

        LFSR lfsr1 = new LFSR(polynom1);
        LFSR lfsr2 = new LFSR(polynom2);
        LFSR lfsr3 = new LFSR(polynom3);

        GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);

//        geffe.step(50);
//        System.out.println(geffe.getGamma());
//        System.out.println(geffe.getBytesOutput());
        System.out.println(geffe.generateMBytes(100));

    }
}
