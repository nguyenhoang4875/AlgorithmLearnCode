package codeforces.div3_826;

import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1741
 */
public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;
    static Integer[] a = new Integer[200010];
    static boolean[] check = new boolean[200010];

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        if (n <= 1) {
            System.out.println(-1);
            return;
        }
        if (n == 3) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
        Arrays.sort(a, 1, n + 1, (a, b) -> b - a);
        if (n % 2 == 1) {
            int mid = (n + 1) / 2;
            Arrays.sort(a, mid, n + 1, (a, b) -> a - b);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
