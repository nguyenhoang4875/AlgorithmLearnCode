package codeforces.div3_847;

import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.*;

public class B {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, s, r;
    static int[] a = new int[55];
    static StringTokenizer st;

    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        s = parseInt(st.nextToken());
        r = parseInt(st.nextToken());

        a[n] = s - r;
        int avg = r / (n - 1);
        for (int i = 1; i < n; i++) {
            a[i] = avg;
        }
        int rm = r - (n - 1) * avg;
        int maxAdd = 6 - avg;
        for (int i = 1; i < n; i++) {
            if (rm > 0) {
                a[i]++;
                rm--;
            } else {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            print(a[i] + " ");
        }
        println("");

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }

    static <T> void print(T t) {
        System.out.print(t);
    }
}