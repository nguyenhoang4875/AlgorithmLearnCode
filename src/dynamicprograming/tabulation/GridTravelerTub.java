package dynamicprograming.tabulation;

import java.util.Arrays;

public class GridTravelerTub {
    public static void main(String[] args) {
        System.out.println(gridTravelerTub(1, 1)); // 1
        System.out.println(gridTravelerTub(2, 3)); // 3
        System.out.println(gridTravelerTub(3, 2)); // 3
        System.out.println(gridTravelerTub(3, 3)); // 6
        System.out.println(gridTravelerTub(18, 18)); // 2333606220
    }

    public static long gridTravelerTub(int m, int n) {
        long[][] table = new long[m + 1][n + 1];
        Arrays.stream(table).forEach(a -> Arrays.fill(a, 0));
        table[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                long current = table[i][j];
                if (j + 1 <= n) table[i][j + 1] += current;
                if (i + 1 <= m) table[i + 1][j] += current;
            }

        }
        return table[m][n];
    }
}

// Time: O(m*n)
// Space: O(m*n)
