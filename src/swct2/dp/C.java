package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/C
 */
public class C {
    static int n;
    static StringTokenizer st;
    static Long[][] h = new Long[2][(int) 1e5 + 5];
    static Long[][] dp = new Long[2][(int) 1e5 + 5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        h[0][0] = 0L;
        h[1][0] = 0L;
        for (int i = 1; i <= n; i++) {
            h[0][i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            h[1][i] = Long.parseLong(st.nextToken());
        }
        dp[0][0] = 0L;
        dp[1][0] = 0L;

        for (int i = 1; i <= n; i++) {
            // calculate the max sum for each element of each row
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + h[0][i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + h[1][i]);
        }
        // get the max sum of two rows
        long ans = Math.max(dp[0][n], dp[1][n]);
        System.out.println(ans);
    }

}

