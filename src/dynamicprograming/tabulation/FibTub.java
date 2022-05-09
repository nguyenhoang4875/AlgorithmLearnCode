package dynamicprograming.tabulation;

import java.util.Arrays;

public class FibTub {

    public static void main(String[] args) {
        System.out.println(fibTub(6)); // 8
        System.out.println(fibTub(8)); // 21
        System.out.println(fibTub(50));// 1258269025

    }

    public static long fibTub(int n) {

        long[] table = new long[n + 2];
        Arrays.fill(table, 0l);
        table[1] = 1l;
        for (int i = 0; i < n; i++) {
            table[i + 1] += table[i];
            table[i + 2] += table[i];
        }

        return table[n];
    }
}

// Time: O(n)
// Space: O(n)
