package kpi.generator.wolfram;

import java.util.ArrayList;
import java.util.List;

public class WolframGenerator {

    private List<Integer> output;
    long r = 1;

    WolframGenerator() {
        newOutput();
    }

    public void step() {
        output.add((int) (r & 1));
        r = (r << 1) ^ (r | (r >>> 1));
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
        }
    }

    private void newOutput() {
        output = new ArrayList<>();
    }

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
        newOutput();
    }

    public List<Integer> getOutput() {
        return output;
    }
}
