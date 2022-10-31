package codeforces.div2_829;

import static java.lang.Math.*;

import java.io.*;
import java.util.*;

import javax.swing.Icon;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, x;
    static int[] arr = new int[500010];
    static StringTokenizer st;
    static int[] dp = new int[500010];

    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dp[1] = 1;
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] * i;
            dp[i] %= x;
        }
        long sum = 0;
        int k;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            k = Integer.parseInt(st.nextToken());
            sum += dp[k];
            sum %= x;
        }
        if (sum == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void main(String[] args) throws IOException {
        tcs = 1;
//        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }
}
