package kpi.generator.bbs;

import java.math.BigInteger;

public class BBSTest {

    public static void main(String[] args) {
        BigInteger p = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
        BigInteger q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
        BBS bbs = new BBS(p, q);
        bbs.setR(new BigInteger("15"));
        //bbs.step(100);
        //System.out.println(bbs.getOutput());
        //System.out.println(bbs.getBytesOutput());
        System.out.println(bbs.generateMBytes(100));

        BBSbytes bbSbytes = new BBSbytes(p, q);
        bbs.setR(new BigInteger("17"));
//        bbSbytes.step(100);
//        System.out.println(bbSbytes.getOutput());
        System.out.println(bbSbytes.generateMBytes(100));
    }
}
