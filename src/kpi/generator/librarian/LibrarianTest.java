package kpi.generator.librarian;

public class LibrarianTest {

    public static void main(String[] args){
        String file = "src/kpi/doc/librarian.text";
        Librarian librarian = new Librarian(file);
        //librarian.generate();
        //System.out.println(librarian.getOutput());
        System.out.println(librarian.generateMBytes());
    }
}
