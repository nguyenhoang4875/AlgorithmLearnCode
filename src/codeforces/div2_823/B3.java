package codeforces.div2_823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/problemset/problem/1730/B
 */
public class B3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] x = new int[100005];
    static int[] t = new int[100005];
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

        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a.add(x[i] - t[i]);
            a.add(x[i] + t[i]);
        }

        int min = a.get(0), max = a.get(0);
        for (int val : a) {
            min = Math.min(min, val);
            max = Math.max(max, val);
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
