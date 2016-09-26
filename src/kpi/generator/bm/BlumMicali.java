package kpi.generator.bm;

import kpi.generator.Generetor;
import kpi.util.BitConverter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlumMicali implements Generetor{
    private BigInteger a;
    private BigInteger p;
    private BigInteger T;
    List<Integer> output = new ArrayList<>();

    public BlumMicali(BigInteger a, BigInteger p) {
        this.a = a;
        this.p = p;
        T = new BigInteger("324267");
    }

    public void step() {
        T = a.modPow(T, p);
        output.add(checkT());
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
        }
    }

    protected Integer checkT() {
        if ((p.subtract(new BigInteger("1"))).divide(new BigInteger("2")).compareTo(T) > 0) {
            return 1;
        } else
            return 0;
    }

    public List<Integer> getBytesOutput() {
        return BitConverter.getBytesOutput(output);
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        step(m*8);
        return getBytesOutput();
    }

    public BigInteger getA() {
        return a;
    }

    public void setA(BigInteger a) {
        this.a = a;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getT() {
        return T;
    }

    public void setT(BigInteger t) {
        T = t;
    }

    public List<Integer> getOutput() {
        return output;
    }
}
