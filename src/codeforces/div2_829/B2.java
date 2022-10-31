package codeforces.div2_829;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;

    static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        int mid = n / 2;
        boolean odd = n % 2 == 1;
        int cnt = 0;
        for (int i = mid; i >= 1; i--) {
            System.out.print(i + " " + (2 * mid - cnt) + " ");
            cnt++;
        }
        if (odd) {
            System.out.println(n);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }
}
