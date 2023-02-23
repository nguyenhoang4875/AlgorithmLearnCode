package codeforces.div2_848;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[] a = sc.next().toCharArray();
            char[] b = sc.next().toCharArray();
            int[][] dp = new int[n + 1][k + 1];
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j];
                    int cnt = 0;
                    for (int p = i; p >= 1; p--) {
                        if (a[p - 1] != b[p - 1]) {
                            cnt++;
                        }
                        if (cnt > j) {
                            break;
                        }
                        dp[i][j] = Math.max(dp[i][j], dp[p - 1][j - cnt] + i - p + 1);
                    }
                }
                ans = Math.max(ans, dp[i][k]);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
