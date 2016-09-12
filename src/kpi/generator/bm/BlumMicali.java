package kpi.generator.bm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlumMicali {

    //public static final long Q = 0x675215CC3E227D3216C056CFA8F8822BB486F788641E85E0DE77097E1DB049F1;
    private long a;
    private long p;
    private long T;
    List<Integer> output = new ArrayList<>();

    BlumMicali(long a, long p) {
        this.a = a;
        this.p = p;
        Random random = new Random();
        T = random.nextLong() % p;
    }

    public void step() {
        T = ApowTmodP();
        output.add(checkT());
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
        }
    }

    protected Integer checkT() {
        if (T < (p - 1)/2) {
            return 1;
        } else
            return 0;
    }

    public long ApowTmodP() {
        long localT = T;
        long result = 1;

        while(localT > 0){
            if(localT % 2 == 1)
                result = result*a % p;
            localT = (long)Math.floor((double)localT/2);
            a = a*a % p;
        }
        return result;
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    public long getP() {
        return p;
    }

    public void setP(long p) {
        this.p = p;
    }

    public long getT() {
        return T;
    }

    public void setT(long t) {
        T = t;
    }

    public List<Integer> getOutput() {
        return output;
    }

    public void setOutput(List<Integer> output) {
        this.output = output;
    }
}
