package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/E
 */
public class E {
    static int n;
    static StringTokenizer st;
    static Long[] size = new Long[3005];
    static Long[] cost = new Long[3005];
    static Long[][] dp = new Long[3][3005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            size[i] = Long.parseLong(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i <= 2; i++) {
            Arrays.fill(dp[i], 0, n + 1, (long) Integer.MAX_VALUE);
        }

        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // save for the largest size
            dp[0][i] = cost[i];
            for (int j = 0; j < i; j++) {
                if (size[i] > size[j]) {
                    // save for middle size
                    dp[1][i] = Math.min(dp[1][i], dp[0][j] + cost[i]);
                    // save for the smallest size
                    dp[2][i] = Math.min(dp[2][i], dp[1][j] + cost[i]);
                }
            }
            ans = Math.min(ans, dp[2][i]);
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

}

