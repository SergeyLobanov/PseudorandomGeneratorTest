package kpi.generator.bm;

import java.math.BigInteger;

public class BlumMicaliBytes extends BlumMicali{

    BlumMicaliBytes(BigInteger a, BigInteger p) {
        super(a, p);
    }

    @Override
    public Integer checkT(){
        //long out = getT()*256/(getP() - 1) + 1;
        BigInteger out = ((getT().multiply(new BigInteger("256")))
                .divide(getP().subtract(new BigInteger("1")))).add(new BigInteger("1"));
        return out.intValue();
    }
}
