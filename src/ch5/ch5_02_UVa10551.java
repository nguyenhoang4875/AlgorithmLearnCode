package ch5;

import java.math.BigInteger;
import java.util.Scanner;

public class ch5_02_UVa10551 { /* UVa 10551 - Basic Remains, 0.345s in Java */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int b = sc.nextInt();
            if (b == 0) break;
            String p_str = sc.next();
            BigInteger p = new BigInteger(p_str, b); // special constructor!
            String m_str = sc.next();
            BigInteger m = new BigInteger(m_str, b); // 2nd parameter is the radix/base
            System.out.println((p.mod(m)).toString(b)); // can output in any radix/base
        }
    }
}
