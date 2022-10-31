package codejam.r2_2021;

import static java.lang.Math.*;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static long a, b, c;
    static StringTokenizer st;
    static StringBuilder sb;
    static final double e = 1e-9;


    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        sb = new StringBuilder();
        long idx = 0;
        long mul = 0;
        long temp = c;
        long before = 0;
        while (temp > 0) {
            mul = a + b * idx;
            idx++;
            temp -= String.valueOf(mul).length();
            if (temp <= 0) {
                before = temp + String.valueOf(mul).length();
            }

        }
        System.out.println("mul = " + mul);
        System.out.println(String.valueOf(mul).charAt((int) (before - 1)));
    }


    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }
}
