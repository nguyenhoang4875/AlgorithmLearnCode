package codeforces.div3_828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Contest: https://codeforces.com/contest/1744
 */
public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, q;
    static long[] a = new long[100010];
    static long type, x;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int co = 0, ce = 0;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            sum += a[i];
            if (a[i] % 2 == 0) ce++;
            else co++;
        }
        while (q-- > 0) {
//            long qsum = sum;
            st = new StringTokenizer(br.readLine());
            type = Long.parseLong(st.nextToken());
            x = Long.parseLong(st.nextToken());
            if (type == 0) {
                sum += ce * x;
                if (x % 2 == 1) {
                    co = n;
                    ce = 0;
                }
            } else {
                sum += co * x;
                if (x % 2 == 1) {
                    ce = n;
                    co = 0;
                }

            }

            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
