package kpi.generator.bbs;

import kpi.generator.Generetor;
import kpi.util.BitConverter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BBS implements Generetor{

    private BigInteger p;
    private BigInteger q;
    protected BigInteger n;
    protected BigInteger r;
    protected List<Integer> output;

    public BBS(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        this.n = p.multiply(q);
        this.r = new BigInteger((new Random().nextInt() + 2) + "");
        output = new ArrayList<>();
    }

    public void step() {
        r = r.multiply(r).remainder(n);
        output.add(newOut());
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
        }
    }

    public int newOut() {
        BigInteger out = r.remainder(new BigInteger("2"));
        return out.intValue();
    }

    public List<Integer> getBytesOutput() {
        return BitConverter.getBytesOutput(output);
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        step(m*8);
        return getBytesOutput();
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getR() {
        return r;
    }

    public void setR(BigInteger r) {
        this.r = r;
    }

    public List<Integer> getOutput() {
        return output;
    }

    public void setOutput(List<Integer> output) {
        this.output = output;
    }
}
