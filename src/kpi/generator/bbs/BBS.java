package kpi.generator.bbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BBS {

    private long p;
    private long q;
    protected long n;
    protected long r;
    protected List<Integer> output;

    public BBS(long p, long q) {
        this.p = p;
        this.q = q;
        this.n = p*q;
        this.r = (new Random().nextInt() + 2);
        output = new ArrayList<>();
    }

    public void step() {
        r = r*r % n;
        output.add(newOut());
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
        }
    }
    public int newOut() {
        long out = r % 2;
        return (int)out;
    }

    public long getP() {
        return p;
    }

    public void setP(long p) {
        this.p = p;
    }

    public long getQ() {
        return q;
    }

    public void setQ(long q) {
        this.q = q;
    }

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
    }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public List<Integer> getOutput() {
        return output;
    }

    public void setOutput(List<Integer> output) {
        this.output = output;
    }
}
