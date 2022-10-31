package codeforces.div3_826;

import static java.lang.Math.*;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1741
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;
    static int[] a = new int[200010];
    static boolean[] check = new boolean[200010];

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        Arrays.fill(a, 1, n, 0);
        Arrays.fill(check, 1, n, false);
        if (n == 3) {
            System.out.println(-1);
            return;
        }
        if (!gen(1)) {
            System.out.println(-1);
        }

    }

    static boolean gen(int i) {
        if (i > n) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            return true;
        }
        for (int val = 1; val <= n; val++) {
            if (!check[val]) {
                a[i] = val;
                check[val] = true;
            }
            if ((i != 1 && abs(a[i] - a[i - 1]) != 1) && (i != n && abs(a[i] - a[i + 1]) != 1) && i != a[i])
                return false;
            gen(i + 1);
            check[val] = false;
        }
        return false;

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
