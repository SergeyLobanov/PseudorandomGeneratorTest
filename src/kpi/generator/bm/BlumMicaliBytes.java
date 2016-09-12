package kpi.generator.bm;

public class BlumMicaliBytes extends BlumMicali{

    BlumMicaliBytes(long a, long p) {
        super(a, p);
    }

    @Override
    public Integer checkT(){
        long out = getT()*256/(getP() - 1) + 1;
        return (int)out;
    }
}
