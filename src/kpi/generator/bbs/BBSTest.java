package kpi.generator.bbs;

public class BBSTest {

    public static void main(String[] args) {
        BBS bbs = new BBS(7, 11);
        bbs.setR(15);
        bbs.step(100);
        System.out.println(bbs.getOutput());

        BBSbytes bbSbytes = new BBSbytes(71, 11);
        bbSbytes.setR(17);
        bbSbytes.step(100);
        System.out.println(bbSbytes.getOutput());
    }
}
