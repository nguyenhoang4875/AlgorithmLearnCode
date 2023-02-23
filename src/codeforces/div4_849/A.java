package codeforces.div4_849;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;

    static void solve() throws IOException {
        String cd = "codeforces";
        String c = br.readLine();
        if (cd.contains(c)) {
            println("YES");
        } else {
            println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
//        tcs = 1;
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }

}