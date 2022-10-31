package codeforces.div3_828;

import static java.lang.Math.*;

import java.io.*;
import java.util.*;

/**
 * Contest: https://codeforces.com/contest/1744
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] a = new int[300010];
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            while (a[i] > 0 && a[i] % 2 == 0) {
                a[i] /= 2;
                cnt++;
            }
        }
        int need = n - cnt;
        if (need <= 0) {
            System.out.println(0);
            return;
        }
        int[] b = new int[n + 5];
        Arrays.fill(b, 0);
        for (int i = 1; i <= n; i++) {
            int temp = i;
            int pow = 0;
            while (temp % 2 == 0) {
                temp /= 2;
                b[i]++;
            }

        }
        int max = b[n];
//        int temp = 1;
//        while ((temp *= 2) <= n) {
//            max++;
//        }
        int all = ((max) * (max + 1)) / 2;
        if (all < need) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        int ct = 0;
        for (int i = max; i >= 1; i--) {
            sum += i;
            ct++;
            if (sum >= need) {
                System.out.println(ct);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
