package kpi.generator.geffe;

import kpi.generator.Generetor;
import kpi.util.BitConverter;
import kpi.util.LFSR;

import java.util.ArrayList;
import java.util.List;

public class GeffeGenerator implements Generetor{
    // linear feedback shift registers
    private LFSR lfsr1;
    private LFSR lfsr2;
    private LFSR lfsr3;
    // gammas
    private List<Integer> gamma;

    public GeffeGenerator(LFSR lfsr1, LFSR lfsr2, LFSR lfsr3) {
        this.lfsr1 = lfsr1;
        this.lfsr2 = lfsr2;
        this.lfsr3 = lfsr3;
        this.gamma = new ArrayList<>();
    }

    public int step() {
        int x = lfsr1.shift();
        int y = lfsr2.shift();
        int s = lfsr3.shift();

        int out = (s & x) ^ ((1 ^ s) & y);

        gamma.add(out);

        return out;
    }

    public void step(int n) {
        for (int i = 0; i < n; i++){
            step();
        }
    }

    public List<Integer> getGamma() {
        return gamma;
    }


    public List<Integer> getBytesOutput() {
        return BitConverter.getBytesOutput(gamma);
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        step(m*8);
        return getBytesOutput();
    }
}
