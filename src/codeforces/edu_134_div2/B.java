package codeforces.edu_134_div2;

import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/**
 * Contest: https://codeforces.com/contest/1721
 */
public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;
    static int n, m, x, y, d;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int disr1 = x - 1;
        int disr2 = n - x;
        int disc1 = y - 1;
        int disc2 = m - y;

        if ((disr1 > d && disc2 > d) || (disr2 > d && disc1 > d)) {
            System.out.println(n + m - 2);
        } else {
            System.out.println(-1);
        }

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }

    }
}
