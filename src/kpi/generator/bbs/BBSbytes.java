package kpi.generator.bbs;

public class BBSbytes extends BBS {

    public BBSbytes(long p, long q) {
        super(p, q);
    }

    public void step() {
        r = r*r % n;
        output.add(newOut());
    }

    @Override
    public int newOut() {
        long out = getR() % 256;
        return (int) out;
    }
}
