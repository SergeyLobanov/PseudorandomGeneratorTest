package kpi.test;

import kpi.generator.bbs.BBS;
import kpi.generator.bbs.BBSbytes;
import kpi.generator.bm.BlumMicali;
import kpi.generator.bm.BlumMicaliBytes;
import kpi.generator.geffe.GeffeGenerator;
import kpi.generator.java.SecureRandomJava;
import kpi.generator.lehmer.high.LehmerHigh;
import kpi.generator.lehmer.low.LehmerLow;
import kpi.generator.librarian.Librarian;
import kpi.generator.wolfram.WolframGenerator;
import kpi.util.BigInitializer;
import kpi.util.BigLFSR;
import kpi.util.Initializer;
import kpi.util.LFSR;

import java.math.BigInteger;

public class HomogeneityTesting {

    public static void main(String[] args) {
        Homogeneity hmTest = new Homogeneity(20);
        hmTest.setGenerateBytes(1000000);
        System.out.println("Test: " + Homogeneity.class.getSimpleName());
        System.out.println("Bytes: " + hmTest.getGenerateBytes() + "\n");

        SecureRandomJava scr = new SecureRandomJava();
        hmTest.test(scr);

        LehmerLow lehmerLow = new LehmerLow();
        lehmerLow.setX0(123141);
        System.out.println("x0: " + lehmerLow.getX0());
        hmTest.test(lehmerLow);

        LehmerHigh lehmerHigh = new LehmerHigh();
        lehmerHigh.setX0(123123123);
        System.out.println("x0: " + lehmerHigh.getX0());
        hmTest.test(lehmerHigh);

        Initializer init20 = new Initializer(20, 17, 15, 11);
        LFSR lfsr20 = new LFSR(init20);
        lfsr20.setInitialState(25658);
        System.out.println("Init state: " + Long.toBinaryString(lfsr20.getInitialState()));
        hmTest.test(lfsr20);

        BigInitializer init89 = new BigInitializer(89, 51);
        BigLFSR lfsr89 = new BigLFSR(init89);
        lfsr89.setInitialState(new BigInitializer(89, 67, 55, 52, 51, 24, 21, 17, 11, 6, 2));
        System.out.println("Init state: " + "(89, 67, 55, 52, 51, 24, 21, 17, 11, 6, 2)");
        hmTest.test(lfsr89);

        Initializer polynom1 = new Initializer(11, 2);
        Initializer polynom2 = new Initializer(9, 4, 3, 1);
        Initializer polynom3 = new Initializer(10, 3);
        LFSR lfsr1 = new LFSR(polynom1);
        LFSR lfsr2 = new LFSR(polynom2);
        LFSR lfsr3 = new LFSR(polynom3);
        GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);
        hmTest.test(geffe);

        String file = "src/kpi/doc/librarian.text";
        Librarian librarian = new Librarian(file);
        hmTest.test(librarian);

        WolframGenerator wolframGenerator = new WolframGenerator();
        wolframGenerator.setR(2424567);
        System.out.println("R: " + wolframGenerator.getR());
        hmTest.test(wolframGenerator);

        BigInteger P = new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
        BigInteger A = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
        BlumMicali blumMicali = new BlumMicali(A, P);
        System.out.println("T: " + blumMicali.getT());
        hmTest.test(blumMicali);

        BlumMicaliBytes blumMicaliBytes = new BlumMicaliBytes(A, P);
        System.out.println("T: " + blumMicaliBytes.getT());
        hmTest.test(blumMicaliBytes);

        BigInteger p = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
        BigInteger q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
        BBS bbs = new BBS(p, q);
        bbs.setR(new BigInteger("4898"));
        System.out.println(bbs.getR());
        hmTest.test(bbs);

        BBSbytes bbSbytes = new BBSbytes(p, q);
        bbSbytes.setR(new BigInteger("5525153"));
        System.out.println("R: " + bbSbytes.getR());
        hmTest.test(bbSbytes);
    }

}
