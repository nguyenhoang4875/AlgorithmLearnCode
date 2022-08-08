package swct2.bruteforce;

import java.util.*;

public class F {
    static long tcs;
    static long[][] arr = new long[210][210];
    static long m, n;
    static long sol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tcs = scanner.nextLong();
        while (tcs-- > 0) {
            sol = 0;
            m = scanner.nextLong();
            n = scanner.nextLong();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextLong();
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sol = Math.max(sol, sumAt2(i, j));
                }
            }
            System.out.println(sol);

        }

    }

    private static long sumAt2(int i, int j) {
        long ans = arr[i][j];
        int tempI = i;
        int count = 0;
        while (--tempI >= 0) {
            count++;
            if (j - count >= 0) {
                ans += arr[tempI][j - count];
            }
            if (j + count < n) {
                ans += arr[tempI][j + count];
            }
        }
        int tempI2 = i;
        count = 0;
        while (++tempI2 < m) {
            count++;
            if (j - count >= 0) {
                ans += arr[tempI2][j - count];
            }
            if (j + count < n) {
                ans += arr[tempI2][j + count];
            }
        }
        return ans;
    }
}
