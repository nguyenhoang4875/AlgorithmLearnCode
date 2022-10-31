package codeforces.dytechlab;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1737
 * Editorial: https://codeforces.com/blog/entry/107567
 */
public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;
    static long l, r;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        l = Long.parseLong(st.nextToken());
        r = Long.parseLong(st.nextToken());
        long ans = count(r) - count(l - 1);
        System.out.println(ans);
    }

    static long findSqrt(long n) {
        long m = 0;
        long ll = 1;
        long rr = (long) 2e9;
        long mid;
        while (ll <= rr) {
            mid = (ll + rr) / 2;
            if (mid * mid <= n) {
                m = mid;
                ll = mid + 1;
            } else {
                rr = mid - 1;
            }
        }
        return m;

    }

    static long count(long n) {
        long m = findSqrt(n);
        long ans = m * 3 - 2;
        if (m * (m + 1) <= n) ans++;
        if (m * (m + 2) <= n) ans++;
        return ans;
    }


    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
