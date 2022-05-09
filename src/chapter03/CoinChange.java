package chapter03;

import java.util.Arrays;

/**
 * Dynamic programming bottom up
 */
public class CoinChange {
    private static int[] coins = {2, 5, 6, 8};
    private static int amount = 13;


    public static int coinChange() {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i : coins) {
            for (int j = i; j <= amount; j++) {
                if (dp[j - i] != Integer.MAX_VALUE) {
                    System.out.printf("dp[%2d] = %2d | ", j, dp[j]);
                    System.out.printf("dp[%2d] + 1 = %2d\n", j - i, dp[j - i] + 1);
                    dp[j] = Math.min(dp[j - i] + 1, dp[j]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("min coin: " + coinChange());
    }
}
