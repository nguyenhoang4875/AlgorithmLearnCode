package chapter02;

import java.util.Random;
import java.util.Vector;

public class Exe_2_2_4 {
    public static void main(String[] args) {
        final int SIZE = 10;
        Random random = new Random();
        Vector<Integer> nums = new Vector<>();
        for (int i = 0; i < SIZE; i++) {
            nums.add(random.nextInt(SIZE));
        }
//        Collections.addAll(nums, 5, 1, 1, 0, 2, 7, 8, 2, 2, 9);
        printVector(nums);
        System.out.println();
        Vector result = rangeSortedOrder(nums, 0, SIZE);
        if (result == null) {
            System.out.println("null");
        } else {
            printVector(result);
        }
    }

    public static Vector<Integer> rangeSortedOrder(Vector<Integer> nums, int a, int b) {
        if (a >= b) return null;
        Vector<Integer> result = new Vector<>();
        Vector<Integer> temp = new Vector<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) >= a) {
                temp.add(nums.get(i));
                while ((i + 1) < nums.size() && nums.get(i + 1) >= nums.get(i) && nums.get(i + 1) <= b) {
                    temp.add(nums.get(i + 1));
                    i++;
                }
            }
            if (temp.size() > result.size()) {
                result = (Vector<Integer>) temp.clone();
            }
            temp.clear();
        }
        return result;
    }

    public static void printVector(Vector vector) {
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }
    }
}
