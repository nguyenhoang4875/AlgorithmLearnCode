package codeforces.edu_142_div2;

import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1795/problem/B
 */
public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, k;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        int l, r;
        boolean cl = false, cr = false;
        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            l = parseInt(st.nextToken());
            r = parseInt(st.nextToken());
            if(l == k) cl = true;
            if(r == k) cr = true;
        }
        println(cl && cr ? "YES" : "NO");

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }

    static <T> void print(T t) {
        System.out.print(t);
    }
}
