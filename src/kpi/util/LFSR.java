package kpi.util;

import kpi.generator.Generetor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFSR implements Generetor{
    // characteristic polynomial of lfsr
    private long polynomial;
    // characteristic polynomial
    private int polynomialDegree;
    // initial state of lfsr
    private long initialState;
    // initial state of lfsr
    private long currentState;
    // generated output sequence
    private StringBuffer outputSequence;
    // list of candidates on key
    private HashMap<Long, String> candidates;

    public LFSR(Initializer initPolynomial, long initialState) {
        this.polynomialDegree = initPolynomial.getDegree();
        this.polynomial = initPolynomial.getValue() ^ ((long)1 << polynomialDegree);
        setInitialState(initialState);
    }

    public LFSR(Initializer initPolynomial) {
        this(initPolynomial, 1);
    }

    public LFSR(Initializer initPolynomial, Initializer initialState) {
        this.polynomialDegree = initPolynomial.getDegree();
        this.polynomial = initPolynomial.getValue() ^ ((long)1 << polynomialDegree);
        setInitialState(initialState.getValue());
    }

    // simple shift of register
    public int shift() {
        int out = (int) (currentState & 1);
        int tempBit = (Long.bitCount((currentState & polynomial))) & 1;

        currentState >>= 1;
        currentState ^= ((long)tempBit << (polynomialDegree - 1));

        outputSequence.append(out);

        return out;
    }

    // n - shifts of register
    public void shift(int n) {
        for (int i = 0; i < n; i++) {
            shift();
        }
    }

    public List<Integer> getBytesOutput() {
        return BitConverter.getBytesListFromBitsString(outputSequence.toString());
    }

    public HashMap<Long, String> getCandidates() {
        return candidates;
    }

    public void setInitialState(long initialState) {
        this.initialState = initialState;
        this.currentState = this.initialState;
        refreshOutputSequence();
    }

    public void setCandidates(HashMap<Long, String> candidates) {
        this.candidates = candidates;
    }

    private void refreshOutputSequence() {
        this.outputSequence = new StringBuffer();
    }

    public long getCurrentState() {
        return currentState;
    }

    public String getBinaryCurrentState() {
        return Long.toBinaryString(currentState);
    }

    public long getPolynomial() {
        return polynomial;
    }

    public int getPolynomialDegree() {
        return polynomialDegree;
    }

    public long getInitialState() {
        return initialState;
    }

    public String getBinaryInitialState() {
        return Long.toBinaryString(initialState);
    }

    public String getOutputSequence() {
        return outputSequence.toString();
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        shift(m*8);
        return getBytesOutput();
    }
}
