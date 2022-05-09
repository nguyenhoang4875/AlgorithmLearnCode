package swpctc.hw02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Workout2 {
    private static final int N = (int) 1e5 + 5;
    private static int n, k;
    static int[] a = new int[N];

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream("src/input_samples.txt"));
//        Scanner scanner = new Scanner(System.in);
        int tcs = scanner.nextInt();
        int tc = 0;
        while (tc++ < tcs) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            int ans = binsearch(1, (int) 1e9);
            System.out.printf("Case #%d: %d\n", tc, ans);
        }
    }

    private static int binsearch(int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo; // lo == hi
    }

    private static boolean check(int d) {
        int reqAdditional = 0;
        for (int i = 1; i + 1 <= n; i++) {
            reqAdditional += (a[i + 1] - a[i] - 1) / d;
        }
        if (reqAdditional <= k) {
            return true;
        }
        return false;
    }

}
