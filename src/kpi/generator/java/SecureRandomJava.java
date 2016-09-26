package kpi.generator.java;

import kpi.generator.Generetor;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class SecureRandomJava implements Generetor{

    private byte[] bytes;
    private List<Integer> output;

    public SecureRandomJava() {
        this.output = new ArrayList<>();
    }

    public void generate(int size) {
        SecureRandom rng = new SecureRandom();
        rng.setSeed(System.currentTimeMillis());
        bytes = new byte[size];
        rng.nextBytes(bytes);
    }

    public List<Integer> getOutputBytes() {
        for (int i : bytes) {
            output.add(i + 128);
        }
        return output;
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        generate(m);
        return getOutputBytes();
    }
}
