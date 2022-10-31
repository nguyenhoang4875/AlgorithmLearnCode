package codeforces.edu_134_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Contest: https://codeforces.com/contest/1721
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static char c1, c2, c3, c4;
    static StringTokenizer st;

    static void solved() throws IOException {
        char[] cs;
        cs = br.readLine().toCharArray();
        c1 = cs[0];
        c2 = cs[1];
        cs = br.readLine().toCharArray();
        c3 = cs[0];
        c4 = cs[1];
        int cnt = 0;
        if (c1 == c2) {
            cnt++;
        }
        if (c1 == c3) {
            cnt++;
        }
        if (c1 == c4) {
            cnt++;
        }
        if (c2 == c3) {
            cnt++;
        }
        if (c2 == c4) {
            cnt++;
        }
        if (c3 == c4) {
            cnt++;
        }
        if (cnt == 0) {
            System.out.println(3);
        }
        if (cnt == 1) {
            System.out.println(2);
        }
        if (cnt == 2) {
            System.out.println(1);
        }
        if (cnt == 3) {
            System.out.println(1);
        }
        if (cnt >= 4) {
            System.out.println(0);
        }

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }

    }
}
