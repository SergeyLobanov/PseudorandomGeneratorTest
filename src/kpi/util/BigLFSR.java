package kpi.util;

import kpi.generator.Generetor;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

public class BigLFSR implements Generetor{
    // characteristic polynomial of lfsr
    private BigInteger polynomial;
    // characteristic polynomial
    private int polynomialDegree;
    // initial state of lfsr
    private BigInteger initialState;
    // initial state of lfsr
    private BigInteger currentState;
    // generated output sequence
    private StringBuffer outputSequence;

    public BigLFSR(BigInitializer initPolynomial, long initialState) {
        this.polynomialDegree = initPolynomial.getDegree();
        this.polynomial = initPolynomial.getValue().xor(new BigInteger("1").shiftLeft(polynomialDegree));
        setInitialState(initialState);
    }

    public BigLFSR(BigInitializer initPolynomial) {
        this(initPolynomial, 1);
    }

    public BigLFSR(BigInitializer initPolynomial, Initializer initialState) {
        this.polynomialDegree = initPolynomial.getDegree();
        this.polynomial = initPolynomial.getValue().xor(new BigInteger("1").shiftLeft(polynomialDegree));
        setInitialState(initialState.getValue());
    }

    // simple shift of register
    public int shift() {
        int out = (currentState.and(new BigInteger("1"))).intValue();
        int tempBit = ((currentState.and(polynomial)).bitCount() & 1);

        currentState = currentState.shiftRight(1);
        currentState = currentState.xor(BigInteger.valueOf(tempBit).shiftLeft(polynomialDegree - 1));
        currentState = currentState.remainder((new BigInteger("1").shiftLeft(polynomialDegree)));

        outputSequence.append(out);

        return out;
    }

    // n - shifts of register
    public void shift(int n) {
        for (int i = 0; i < n; i++) {
//            if(i%5000000==0) {
//                System.out.println(i);
//                System.out.println(currentState);
//                System.out.println(getBytesOutput());
//            }
            shift();
        }
    }

    public List<Integer> getBytesOutput() {
        return BitConverter.getBytesListFromBitsString(outputSequence.toString());
    }

    public void setInitialState(long initialState) {
        this.initialState = BigInteger.valueOf(initialState);
        this.currentState = this.initialState;
        refreshOutputSequence();
    }

    private void refreshOutputSequence() {
        this.outputSequence = new StringBuffer();
    }



    public String getOutputSequence() {
        return outputSequence.toString();
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        shift(m*8);
        return getBytesOutput();
    }

    public void setInitialState(BigInitializer bigInitializer) {
        this.initialState = bigInitializer.getValue();
        this.currentState = this.initialState;
        refreshOutputSequence();
    }
}
