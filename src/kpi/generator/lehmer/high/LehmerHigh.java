package kpi.generator.lehmer.high;

import kpi.generator.lehmer.LehmerGenerator;

import java.util.List;

public class LehmerHigh extends LehmerGenerator {

    public LehmerHigh() {
    }

    public LehmerHigh(int a, int c, long m, long x0) {
        super(a, c, m, x0);
    }

    public LehmerHigh(int a, int c, long m) {
        super(a, c, m);
    }

    public int getGeneratedBytes(long Xn) {
        return (int)(Xn >> 24);
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        generateSequence(m);
        return getGeneratedElements();
    }
}
