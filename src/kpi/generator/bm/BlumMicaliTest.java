package kpi.generator.bm;

public class BlumMicaliTest {

    public static void main(String[] args) {

        BlumMicali blumMicali = new BlumMicali(4, 11);
        blumMicali.setT(2);
        blumMicali.step(100);
        System.out.println(blumMicali.getOutput());

        BlumMicaliBytes blumMicaliBytes = new BlumMicaliBytes(4, 11);
        blumMicali.setT(2);
        blumMicali.step(100);
        System.out.println(blumMicali.getOutput());
    }
}
