package kpi.generator.librarian;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Librarian {

    String text;
    List<Integer> output;


    public Librarian(String text) {
        this.text = text;
        this.output = new ArrayList<>();
    }

    public void generate() {
        for (char c : text.toCharArray()) {
            output.add((int)c);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Integer> getOutput() {
        return output;
    }

    public void setOutput(List<Integer> output) {
        this.output = output;
    }
}
