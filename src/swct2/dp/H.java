package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/H
 */
public class H {
    final static long INF = (long) 3e18;
    static int tcs;
    static StringTokenizer st;
    static int n;
    static long a, b;
    static String line;
    static long[][] dp = new long[2][(int) 2e5 + 5];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            line = br.readLine();

            Arrays.fill(dp[0], 0, n + 2, INF);
            Arrays.fill(dp[1], 0, n + 2, INF);

            dp[0][0] = b;
            dp[1][0] = INF;
            for (int i = 0; i < n; i++) {
                if (line.charAt(i) == '0') {
                    dp[0][i + 1] = Math.min(dp[0][i] + a + b, dp[1][i] + 2 * a + b);
                    dp[1][i + 1] = Math.min(dp[0][i] + 2 * a + 2 * b, dp[1][i] + a + 2 * b);
                } else {
                    dp[0][i + 1] = INF;
                    dp[1][i + 1] = dp[1][i] + a + 2 * b;
                }
            }

            System.out.println(dp[0][n]);
        }
    }

}

