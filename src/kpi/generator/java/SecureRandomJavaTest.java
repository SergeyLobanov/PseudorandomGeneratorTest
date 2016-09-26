package kpi.generator.java;

public class SecureRandomJavaTest {

    public static void main(String[] args) {
        SecureRandomJava scr = new SecureRandomJava();
//        scr.generate(100);
//        System.out.println(scr.getOutputBytes());
        System.out.println(scr.generateMBytes(100));
    }
}
