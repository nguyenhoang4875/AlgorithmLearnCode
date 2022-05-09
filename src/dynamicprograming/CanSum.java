package dynamicprograming;

import java.util.HashMap;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        long start, end;
        start = System.currentTimeMillis();
        System.out.println(canSum(300, new int[]{11, 22}));
        end = System.currentTimeMillis();
        System.out.println("time1: " + (end - start));
        System.out.println("-------------------------------------------");
        start = System.currentTimeMillis();
        System.out.println(canSumMemorize(300, new int[]{11, 22}, new HashMap<>()));
        end = System.currentTimeMillis();
        System.out.println("time2: " + (end - start));
    }


    public static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers)) return true;
        }
        return false;
    }

    public static boolean canSumMemorize(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
}
