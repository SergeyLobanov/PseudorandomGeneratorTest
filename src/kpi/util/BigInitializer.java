package kpi.util;

import java.math.BigInteger;

/**
 * Created by Сергей on 14.05.2016.
 */
public class BigInitializer {
    private BigInteger value;
    private int degree;

    // constructor with various count of arguments (degrees of polynomial) or just value
    public BigInitializer(int ... coefficients) {
        if (coefficients.length == 1) {
            this.value = BigInteger.valueOf(coefficients[0]);
        } else {
            this.degree = coefficients[0];
            this.value = new BigInteger("1");
            for (int i : coefficients) {
                value = value.xor(BigInteger.valueOf((long)1 << i));
            }
        }
    }

    public int getDegree(){
        return degree;
    }

    public BigInteger getValue() {
        return value;
    }
}
