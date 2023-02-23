package dynamicprograming;

import static java.lang.Math.*;

import java.util.*;

public class Knapsack {
    public static void main(String[] args) {

        int[] w = {3, 1, 3, 4, 2};
        int[] v = {2, 2, 4, 5, 3};
        int cap = 7;
//        int[] w = {2, 3, 4, 5};
//        int[] v = {1, 2, 5, 6};
//        int cap = 8;
        int ans = knap(cap, w, v);
        System.out.println(ans);

    }

    static int knap(int cap, int[] w, int[] v) {
        int n = w.length;
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            int vi = v[i - 1];
            int wi = w[i - 1];

            for (int j = 1; j <= cap; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= wi && dp[i][j] < dp[i - 1][j - wi] + vi) {
                    dp[i][j] = dp[i - 1][j - wi] + vi;
                }
            }
        }

        List<Integer> items = new ArrayList<>();
        int size = cap;
        for (int i = n; i >= 1; i--) {
            if (dp[i][size] != dp[i - 1][size]) {
                items.add(i - 1);
                size -= w[i - 1];
            }
        }
        Collections.reverse(items);
        items.forEach(x -> System.out.print(x + " "));
        System.out.println();
        return dp[n][cap];
    }
}
