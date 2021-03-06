package kpi.generator.bm;

import kpi.util.BitConverter;

import java.math.BigInteger;

public class BlumMicaliTest {

    public static void main(String[] args) {

        BigInteger P = new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
        BigInteger A = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);


        BlumMicali blumMicali = new BlumMicali(A, P);
//        blumMicali.step(100);
//        System.out.println(blumMicali.getOutput());
//        System.out.println(blumMicali.getBytesOutput());
        System.out.println(blumMicali.generateMBytes(100));//x8

        BlumMicaliBytes blumMicaliBytes = new BlumMicaliBytes(A, P);
        //blumMicaliBytes.step(100);
        //System.out.println(blumMicaliBytes.getOutput());
        System.out.println(blumMicaliBytes.generateMBytes(100));
    }
}
