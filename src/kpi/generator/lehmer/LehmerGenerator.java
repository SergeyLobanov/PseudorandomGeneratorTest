package kpi.generator.lehmer;

import java.util.ArrayList;
import java.util.List;

//Linear congruential generator
public abstract class LehmerGenerator {
    private int a = (1 << 16) + 1;
    private int c = 119;
    private long m = 1L << 32;
    private long x0 = 1;
    protected List<Long> generatedSequence;
    protected List<Integer> generatedElements;

    public LehmerGenerator() {
        newGeneratedSequence();
    }

    public LehmerGenerator(int a, int c, long m, long x0) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.x0 = x0;
        newGeneratedSequence();
    }

    public LehmerGenerator(int a, int c, long m) {
        this(a, c, m, 1);
    }

    //Xn = (a*Xn-1 + c) mod m
    public long next(long value) {
        return (a*value + c) & (m - 1);
    }

    public void generateSequence() {
        long Xn = next(generatedSequence.get(generatedSequence.size()-1));
        generatedSequence.add(Xn);
        generatedElements.add(getGeneratedBytes(Xn));
    }

    public void generateSequence(int n) {
        for (int i = 0; i < n; i++) {
            generateSequence();
        }
    }

    public abstract int getGeneratedBytes(long Xn);

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        newGeneratedSequence();
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
        newGeneratedSequence();
    }

    public long getM() {
        return m;
    }

    public void setM(long m) {
        this.m = m;
        newGeneratedSequence();
    }

    public long getX0() {
        return x0;
    }

    public void setX0(long x0) {
        this.x0 = x0;
        newGeneratedSequence();
    }

    public List<Long> getGeneratedSequence() {
        return generatedSequence;
    }

    public void setGeneratedSequence(List<Long> generatedSequence) {
        this.generatedSequence = generatedSequence;
    }

    public void setGeneratedElements(List<Integer> generatedElements) {
        this.generatedElements = generatedElements;
    }

    public List<Integer> getGeneratedElements() {
        return generatedElements;
    }

    protected void newGeneratedSequence() {
        generatedSequence = new ArrayList<>();
        generatedElements = new ArrayList<>();
        generatedSequence.add(x0);
        generatedElements.add(getGeneratedBytes(getX0()));
    }
}
