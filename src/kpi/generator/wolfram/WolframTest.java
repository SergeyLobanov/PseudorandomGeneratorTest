package kpi.generator.wolfram;

public class WolframTest {

    public static void main(String[] args) {
        WolframGenerator wolframGenerator = new WolframGenerator();
        wolframGenerator.setR(10);
        wolframGenerator.step(50);
        System.out.println(wolframGenerator.getOutput());
    }
}
