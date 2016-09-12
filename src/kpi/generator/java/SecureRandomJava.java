package kpi.generator.java;

import java.security.SecureRandom;

public class SecureRandomJava {

    public static void main(String[] args) {
        SecureRandom rng = new SecureRandom();
        rng.setSeed(System.currentTimeMillis());
        byte[] randomBytes = new byte[20];
        rng.nextBytes(randomBytes);
        for (int i = 0; i < 20; i++) {
            System.out.println(randomBytes[i]);
        }
    }
}
