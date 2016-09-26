package kpi.generator.librarian;

import kpi.generator.Generetor;
import kpi.util.FileWork;

import java.util.ArrayList;
import java.util.List;

public class Librarian implements Generetor{

    String file;
    List<Integer> output;


    public Librarian(String file) {
        this.file = file;
        this.output = new ArrayList<>();
    }

    public void generate() {
        output = FileWork.readBytesFromFile(file);
    }

    @Override
    public List<Integer> generateMBytes(int m) {
        generate();
        return getOutput();
    }

    public List<Integer> generateMBytes() {
        return generateMBytes(0);
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<Integer> getOutput() {
        return output;
    }

    public void setOutput(List<Integer> output) {
        this.output = output;
    }
}
