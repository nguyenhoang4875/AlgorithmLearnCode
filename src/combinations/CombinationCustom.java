package combinations;

public class CombinationCustom {
    public static void main(String[] args) {
        int data[] = new int[]{1, 2, 3};
        int n = data.length;
        printCombination(data, n, 2);

    }

    /**
     * Method 1 (Fix Elements and Recur)
     *
     * @param arr
     * @param data
     * @param start
     * @param end
     * @param index
     * @param r
     */
    public static void combinationUtil1(int[] arr, int[] data, int start, int end, int index, int r) {
        if (index == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil1(arr, data, i + 1, end, index + 1, r);

        }
    }

    /**
     * Method 2 (Include and Exclude every element)
     *
     * @param arr
     * @param data
     * @param start
     * @param end
     * @param index
     * @param r
     */
    public static void combinationUtil2(int[] arr, int[] data, int start, int end, int index, int r) {
        if (index == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }
        if (start > end) {
            return;
        }

        data[index] = arr[start];
        combinationUtil2(arr, data, start + 1, end, index + 1, r);
        combinationUtil2(arr, data, start + 1, end, index, r);

    }


    public static void printCombination(int[] arr, int n, int r) {
        int[] data = new int[r];
        combinationUtil1(arr, data, 0, n - 1, 0, r);
        System.out.println("*****************************");
        combinationUtil2(arr, data, 0, n - 1, 0, r);
    }

    public static void generate(int[] data) {
        if (data.length <= 1) {
            return;
        }
        int n = data.length;

        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) > 0) {
                    System.out.print(data[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
