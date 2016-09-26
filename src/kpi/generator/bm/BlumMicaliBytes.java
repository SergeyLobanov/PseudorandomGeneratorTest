package kpi.generator.bm;

import java.math.BigInteger;
import java.util.List;

public class BlumMicaliBytes extends BlumMicali{

    public BlumMicaliBytes(BigInteger a, BigInteger p) {
        super(a, p);
    }

    @Override
    public Integer checkT(){
        //long out = getT()*256/(getP() - 1);
        BigInteger out = (getT().multiply(new BigInteger("256")))
                .divide(getP().subtract(new BigInteger("1")));
        return out.intValue();
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        step(m);
        return output;
    }
}
