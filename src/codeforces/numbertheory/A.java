package codeforces.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1738
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, x;
    static int[] a = new int[100005];
    static StringTokenizer st;
    static long ans = 0;


    static void solved() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int t;
        ans = 0;
        ans += (long) x * (x + 1) / 2;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            t = Integer.parseInt(st.nextToken());
            if (t <= x) {
                ans -= 2L * t;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
