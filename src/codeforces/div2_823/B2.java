package codeforces.div2_823;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/problemset/problem/1730/B
 */
public class B2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] x = new int[100005];
    static int[] t = new int[100005];
    static int[] a = new int[200005];
    static double MAX = 2e9;
    static StringTokenizer st;


    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        int index = 1;
        for (int i = 1; i < 2 * n; i += 2) {
            a[i] = x[index] - t[index];
            a[i + 1] = x[index] + t[index];
            index++;

        }

        int min = a[1], max = a[1];
        for (int i = 1; i <= 2 * n; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        double ans = (min + max) / 2.0;
        System.out.println(ans);


    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
