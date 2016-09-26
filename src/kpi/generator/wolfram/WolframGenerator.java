package kpi.generator.wolfram;

import kpi.generator.Generetor;
import kpi.util.BitConverter;

import java.util.ArrayList;
import java.util.List;

public class WolframGenerator implements Generetor{

    private List<Integer> output;
    long r = 1;

    public WolframGenerator() {
        newOutput();
    }

    public void step() {
        output.add((int) (r & 1));
        r = (cycleLeftShift(r)) ^ (r | (r >>> 1));
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
        }
    }

    private long cycleLeftShift(long toShift) {
        long last = (toShift >> 31) & 1;
        long began = (toShift << 1);
        long result = began | last;
        return result;
    }

    public List<Integer> getBytesOutput() {
        return BitConverter.getBytesOutput(output);
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

    @Override
    public List<Integer> generateMBytes(int m) {
        step(m*8);
        return getBytesOutput();
    }
}
