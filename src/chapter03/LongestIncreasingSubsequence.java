package chapter03;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{-7, 10, 9, 2, 3, 8, 8, 1, 2, 3, 4};
        int[] list = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            list[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && list[i] < list[j] + 1) {
                    list[i] += 1;
                }
            }
        }

        Arrays.sort(list);
        System.out.println("longest increasing subsequence: " + list[list.length - 1]);
    }
}
