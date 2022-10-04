package codeforces.div2_823;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/problemset/problem/1730/B
 */
public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] x = new int[100005];
    static int[] t = new int[100005];
    static double MAX = 2e9;
    static StringTokenizer st;


    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        // binary search to find the min of max time one people consume to get the meeting
        double l = 0;
        double r = MAX;
        double tMin = 0;
        double e = 1e-6; // the maximum different with the correct answer.
        double mid;
        while (r - l > e) {
            mid = (l + r) / 2;
            if (check(mid)) {
                tMin = mid;
                r = mid;
            } else {
                l = mid;
            }
        }

        // find the x0 where to conduct the meeting
        double mxl = 0;
        for (int i = 1; i <= n; i++) {
            mxl = Math.max(mxl, x[i] - (tMin - t[i]));
        }
        System.out.println(mxl);
    }

    static boolean check(double v) {
        double minR = MAX;
        double maxL = 0;
        for (int i = 1; i <= n; i++) {
            if (t[i] > v) {
                // t[i] must to less or equal v (min time to get x0)
                return false;
            }
            maxL = Math.max(maxL, x[i] - (v - t[i]));
            minR = Math.min(minR, x[i] + (v - t[i]));
        }
        return minR >= maxL;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
