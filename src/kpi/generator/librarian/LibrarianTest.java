package kpi.generator.librarian;

import kpi.util.FileWork;

public class LibrarianTest {

    public static void main(String[] args) {
        String file = "src/kpi/librarian.text";
        String text = FileWork.readFile(file);
        Librarian librarian = new Librarian(text);
        librarian.generate();
        System.out.println(librarian.getOutput());
    }
}
