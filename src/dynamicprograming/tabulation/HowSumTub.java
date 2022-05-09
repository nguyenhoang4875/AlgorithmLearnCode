package dynamicprograming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowSumTub {
    // this solution does not work
    public static void main(String[] args) {
        System.out.println(howSumTub(7, new int[]{2, 3})); // [3, 2, 2]

    }

    public static List<Integer> howSumTub(int targetSum, int[] numbers) {
        List<ArrayList<Integer>> table = new ArrayList<>();
        for (int i = 0; i < targetSum + 1; i++) {
            table.add(new ArrayList<>());
        }

        for (int i = 0; i < targetSum; i++) {
            if (i == 0 || table.get(i).size() > 0) {

                for (int num : numbers) {
                    if (i + num <= targetSum) {
                        for (Integer a : table.get(i)) {
                            table.get(i + num).add(a);
                        }
                        table.get(i + num).add(num);
                    }

                }
            }

        }

        table.get(targetSum).forEach(x -> System.out.println(x));
        return table.get(targetSum);
    }
}
