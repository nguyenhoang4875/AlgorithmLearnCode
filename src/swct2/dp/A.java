package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static long tcs;
    static long[][] arr = new long[210][210];
    static long[][][] dp = new long[4][300][300];
    static int m, n;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tcs = Long.parseLong(br.readLine());
        while (tcs-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= m; i++) {
                arr[i][0] = 0;
            }
            for (int i = 0; i <= n; i++) {
                arr[0][i] = 0;
            }
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Long.parseLong(st.nextToken());
                }
            }

            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j < m + 5; j++) {
                    for (int k = 0; k < n + 5; k++) {
                        dp[i][j][k] = 0;
                    }
                }
            }

            // top left
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[0][i][j] = dp[0][i - 1][j - 1] + arr[i][j];
                }
            }

            // bottom right
            for (int i = m; i >= 1; i--) {
                for (int j = n; j >= 1; j--) {
                    dp[1][i][j] = dp[1][i + 1][j + 1] + arr[i][j];
                }
            }


            // top right
            for (int i = 1; i <= m; i++) {
                for (int j = n; j >= 1; j--) {
                    dp[2][i][j] = dp[2][i - 1][j + 1] + arr[i][j];
                }
            }

            // bottom left
            for (int i = m; i >= 1 ; i--) {
                for (int j = 1; j <=  n; j++) {
                    dp[3][i][j] = dp[3][i + 1][j - 1] + arr[i][j];
                }
            }

            long ans = Long.MIN_VALUE;
            long tempSum = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    tempSum = arr[i][j] + dp[0][i - 1][j - 1] + dp[1][i + 1][j + 1]
                            + dp[2][i - 1][j + 1] + dp[3][i + 1][j - 1];
                    ans = Math.max(ans, tempSum);
                }
            }
            System.out.println(ans);
        }
    }

}

