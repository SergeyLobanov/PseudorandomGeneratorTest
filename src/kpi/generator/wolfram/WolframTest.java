package kpi.generator.wolfram;

public class WolframTest {

    public static void main(String[] args) {
        WolframGenerator wolframGenerator = new WolframGenerator();
        wolframGenerator.setR(2424567);
//        wolframGenerator.step(5000);
//        System.out.println(wolframGenerator.getOutput());
        System.out.println(wolframGenerator.generateMBytes(100));
    }
}
