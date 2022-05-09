package utils;

import java.util.Arrays;

public class NextPermutationCustom {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        long start = System.nanoTime();
        nextPermutation(arr);
        long end = System.nanoTime();
        System.out.println("time: " + (end - start));
        System.out.println(Arrays.toString(arr).replace(" ", ""));

    }

    public static boolean nextPermutation(int[] data) {
        if (data.length <= 1) {
            return false;
        }

        int lastIndexNotASC = data.length - 2;

        while (lastIndexNotASC >= 0 && data[lastIndexNotASC] >= data[lastIndexNotASC + 1]) {
            lastIndexNotASC--;
        }
        if (lastIndexNotASC < 0) return false;

        int nextGreater = data.length - 1;

        while (data[nextGreater] <= data[lastIndexNotASC]) {
            nextGreater--;
        }
        swap(data, lastIndexNotASC, nextGreater);
        reverse(data, lastIndexNotASC + 1, data.length - 1);
        return true;
    }

    public static int[] swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data;
    }

    public static int[] reverse(int[] data, int i, int j) {

        while (i < j) {
            int temp = data[i];
            data[i++] = data[j];
            data[j--] = temp;
        }
        return data;
    }
}
