package kpi.generator.lehmer.low;

import kpi.generator.lehmer.LehmerGenerator;

import java.util.List;

public class LehmerLow extends LehmerGenerator {

    public LehmerLow() {
    }

    public LehmerLow(int a, int c, long m, long x0) {
        super(a, c, m, x0);
    }

    public LehmerLow(int a, int c, long m) {
        super(a, c, m);
    }

    @Override
    public int getGeneratedBytes(long Xn) {
        return (int)(Xn & ((1<<8) - 1));
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        generateSequence(m);
        return getGeneratedElements();
    }
}
