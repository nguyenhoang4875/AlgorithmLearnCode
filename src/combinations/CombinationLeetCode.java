package combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationLeetCode {
    public static void main(String[] args) {
        CombinationLeetCode temp = new CombinationLeetCode();
        temp.combine(4, 2);

        List<List<Integer>> result = temp.combine(1, 1);
        for (List<Integer> num : result) {
            System.out.println(num);
        }
    }


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int[] data = new int[k];
        combinationUtil2(arr, data, 0, n - 1, 0, k, result);

        return result;
    }

    public static void combinationUtil2(int[] arr, int[] data, int start, int end, int index, int r, List<List<Integer>> results) {
        if (index == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                temp.add(data[i]);
            }
            results.add(temp);
            return;
        }
        if (start > end) {
            return;
        }

        data[index] = arr[start];
        combinationUtil2(arr, data, start + 1, end, index + 1, r, results);
        combinationUtil2(arr, data, start + 1, end, index, r, results);
    }
}
