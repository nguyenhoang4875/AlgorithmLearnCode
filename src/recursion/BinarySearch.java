package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 8, 9};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 11));
        System.out.println(binarySearchIndex(arr, 0, arr.length - 1, 100));
    }

    public static int binarySearch(int[] arr, int left, int right, int x) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (x == arr[mid]) {
            return mid;
        }

        if (x < arr[mid]) {
            return binarySearch(arr, left, mid - 1, x);
        }

        return binarySearch(arr, mid + 1, right, x);
    }

    public static int binarySearchIndex(int[] arr, int left, int right, int x) {
        if (left > right) {
            return left;
        }

        int mid = (left + right) / 2;

        if (x == arr[mid]) {
            return mid;
        }

        if (x < arr[mid]) {
            return binarySearchIndex(arr, left, mid - 1, x);
        }

        return binarySearchIndex(arr, mid + 1, right, x);
    }
}
