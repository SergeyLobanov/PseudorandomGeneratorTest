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
import kpi.util.Initializer;
import kpi.util.LFSR;

import java.math.BigInteger;

public class EqualProbabilityTest {

    public static void main(String[] args) {
        SecureRandomJava scr = new SecureRandomJava();
        EqualProbability.test(scr.generateMBytes(100));

        String file = "src/kpi/doc/librarian.text";
        Librarian librarian = new Librarian(file);
        EqualProbability.test(librarian.generateMBytes());

        Initializer init20 = new Initializer(20, 17, 15, 11);
        LFSR lfsr20 = new LFSR(init20);
        lfsr20.setInitialState(1);
        EqualProbability.test(lfsr20.generateMBytes(100));

        Initializer init89 = new Initializer(89, 51);
        LFSR lfsr89 = new LFSR(init89);
        lfsr89.setInitialState(1);
        EqualProbability.test(lfsr89.generateMBytes(100));

        Initializer polynom1 = new Initializer(11, 2);
        Initializer polynom2 = new Initializer(9, 4, 3, 1);
        Initializer polynom3 = new Initializer(10, 3);
        LFSR lfsr1 = new LFSR(polynom1);
        LFSR lfsr2 = new LFSR(polynom2);
        LFSR lfsr3 = new LFSR(polynom3);
        GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);
        EqualProbability.test(geffe.generateMBytes(100));

        System.out.println("LehmerLow");
        LehmerLow lehmerLow = new LehmerLow();
        EqualProbability.test(lehmerLow.generateMBytes(100));

        System.out.println("LehmerHigh");
        LehmerHigh lehmerHigh = new LehmerHigh();
        lehmerHigh.setX0(123123123);
        EqualProbability.test(lehmerHigh.generateMBytes(100));

        WolframGenerator wolframGenerator = new WolframGenerator();
        wolframGenerator.setR(2424567);
        EqualProbability.test(wolframGenerator.generateMBytes(100));

        BigInteger p = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
        BigInteger q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
        BBS bbs = new BBS(p, q);
        bbs.setR(new BigInteger("15"));
        EqualProbability.test(bbs.generateMBytes(100));

        BBSbytes bbSbytes = new BBSbytes(p, q);
        bbs.setR(new BigInteger("17"));
        EqualProbability.test(bbSbytes.generateMBytes(100));

        BigInteger P = new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
        BigInteger A = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
        BlumMicali blumMicali = new BlumMicali(A, P);
        EqualProbability.test(blumMicali.generateMBytes(100));

        BlumMicaliBytes blumMicaliBytes = new BlumMicaliBytes(A, P);
        EqualProbability.test(blumMicaliBytes.generateMBytes(100));
    }
}
