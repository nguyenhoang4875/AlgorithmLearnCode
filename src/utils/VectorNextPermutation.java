package utils;

import java.util.Collections;
import java.util.Vector;

public class VectorNextPermutation {

    // Function to reverse the sub-array
    // starting from left to the right
    // both inclusive
    public static Vector<Integer> reverse(Vector<Integer> data, int left, int right) {

        // Reverse the sub-array
        while (left < right) {
            int temp = data.get(left);
            data.set(left++, data.get(right));
            data.set(right--, temp);
        }

        // Return the updated array
        return data;
    }

    // Function to find the next permutation
    // of the given integer array
    public static boolean findNextPermutation(Vector<Integer> data) {

        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.size() <= 1)
            return false;

        int last = data.size() - 2;

        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data.get(last) < data.get(last + 1)) {
                break;
            }
            last--;
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return false;

        int nextGreater = data.size() - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.size() - 1; i > last; i--) {
            if (data.get(i) > data.get(last)) {
                nextGreater = i;
                break;
            }
        }

        int arr[] = new int[3];
        // Swap the successor and the pivot
        Collections.swap(data, nextGreater, last);

        // Reverse the suffix
        reverse(data, last + 1, data.size() - 1);

        // Return true as the next_permutation is done
        return true;
    }

    // Driver Code
    public static void main(String args[]) {
        Vector<Integer> data = new Vector<>();
        Collections.addAll(data, 3, 2, 1);
        if (!findNextPermutation(data))
            System.out.println("There is no higher order permutation for the given data.");
        else {
            data.forEach(x -> System.out.print(x + "  "));
        }
    }
}
