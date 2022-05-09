package dynamicprograming;

import java.util.Arrays;

public class HowSum {
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3})); // [3,2,2]
        System.out.println(howSum(7, new int[]{5, 3, 4, 7})); // [4,3]
        System.out.println(howSum(7, new int[]{2, 4})); //  null
        System.out.println(howSum(8, new int[]{2, 3, 5})); // [2,2,2,2]
    }

    public static int[] howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return null;
        if (targetSum < 0) return null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            int[] remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
                int[] result = Arrays.copyOf(remainderResult, remainderResult.length + 1);
                result[result.length - 1] = num;
                return result;
            }
        }
        return null;
    }
}
