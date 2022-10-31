package codeforces.div3_826;

import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://codeforces.com/contest/1741
 */
public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;
    static int[] a = new int[262150];
    static boolean[] check = new boolean[200010];
    static int count;

    static void solved() throws IOException {
        count = 0;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n - 1; i += 2) {
            if (abs(a[i] - a[i + 1]) != 1) {
                System.out.println(-1);
                return;
            } else {
                if (a[i] > a[i + 1]) {
                    count++;
                }
            }
        }
        check(1, n);

    }

    static boolean check(int l, int r) {
        int m = r / 2;
        System.out.println("m = " + m);
        if (m != l && m != r) {
            check(l, m);
            check(m + 1, r);
        }
        return true;

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
