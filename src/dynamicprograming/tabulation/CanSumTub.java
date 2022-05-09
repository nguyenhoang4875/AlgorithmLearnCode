package dynamicprograming.tabulation;

import java.util.Arrays;

public class CanSumTub {

    public static void main(String[] args) {
        System.out.println(canSumTub(7, new int[]{2, 3})); // true
        System.out.println(canSumTub(7, new int[]{5, 3, 4, 7})); // true
        System.out.println(canSumTub(7, new int[]{2, 4})); // false
        System.out.println(canSumTub(8, new int[]{2, 3, 5})); // true
        System.out.println(canSumTub(300, new int[]{7, 14})); // false
    }

    public static boolean canSumTub(int target, int[] numbers) {
        boolean[] table = new boolean[target + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i < target; i++) {
            if (table[i] == true) {
                for (int num : numbers) {
                    if (i + num <= target) table[i + num] = true;
                }
            }
        }

        return table[target];
    }
}

// m = target, n = number.length
// Time O(m*m)
// Space O(m)
