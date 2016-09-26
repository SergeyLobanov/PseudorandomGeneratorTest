package kpi.generator.bbs;

import java.math.BigInteger;
import java.util.List;

public class BBSbytes extends BBS {

    public BBSbytes(BigInteger p, BigInteger q) {
        super(p, q);
    }

    @Override
    public int newOut() {
        BigInteger out = getR().remainder(new BigInteger("256"));
        return out.intValue();
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        step(m);
        return output;
    }
}
