package kpi.test;

import kpi.generator.Generetor;
import kpi.test.constant.Quantile;

import java.util.List;

public abstract class Test {
    private int generateBytes = 1000000;
    protected int l;

    public void test(Generetor generetor) {
        List<Integer> sequence = generetor.generateMBytes(generateBytes);
        System.out.println(generetor.getClass().getSimpleName());
        double statistic = calculateStatistic(sequence);
        System.out.println("a = 0.01: " + statistic + " < " + getLimit(Quantile.Q0_01)
                + " : " + (statistic < getLimit(Quantile.Q0_01)));
        System.out.println("a = 0.05: " + statistic + " < " + getLimit(Quantile.Q0_05)
                + " : " + (statistic < getLimit(Quantile.Q0_05)));
        System.out.println("a = 0.1: " + statistic + " < " + getLimit(Quantile.Q0_1)
                + " : " + (statistic < getLimit(Quantile.Q0_1)));
        System.out.println();
    }
    public void setGenerateBytes(int generateBytes) {
        this.generateBytes = generateBytes;
    }

    public int getGenerateBytes() {
        return generateBytes;
    }

    public abstract double calculateStatistic(List<Integer> sequence);

    public double getLimit(double quantile) {
        return Math.sqrt(2*getL())*quantile + getL();
    }

    public int getL() {
        return l;
    }
}
