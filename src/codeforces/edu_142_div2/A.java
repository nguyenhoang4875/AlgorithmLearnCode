package codeforces.edu_142_div2;

import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1795/problem/A
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, m;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        String s1 = br.readLine();
        String s2 = br.readLine();
        StringBuilder sb = new StringBuilder(s1);
        for (int i = s2.length() -1 ;  i >= 0; i--) {
            sb.append(s2.charAt(i));
        }
        int cnt = 0;
        for (int i = 0; i < sb.length() - 1; i++) {
           if (sb.charAt(i) == sb.charAt(i+1)) {
               cnt++;
           }
        }
        if (cnt <= 1) println("YES");
        else println("NO");
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
