package kpi.generator.lehmer.high;

import kpi.generator.lehmer.LehmerGenerator;

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
}
