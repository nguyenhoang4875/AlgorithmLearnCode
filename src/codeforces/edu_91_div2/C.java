package codeforces.edu_91_div2;

import java.io.*;
import java.util.*;

/**
 * Contest: https://codeforces.com/contest/1380/problem/C
 */
public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, x;
    static int[] a = new int[100005];
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, 1, n + 1);
        int ans = 0;
        boolean gx = false;
        int igx = n + 1; // init value for case all programmers have skill less than x;
        for (int i = 1; i <= n; i++) {
            // Count when a[i] > x
            if (a[i] >= x) {
                if (!gx) {
                    gx = true;
                    igx = i;
                }
                ans++;
            }
        }

        int cnt = 0;
        int sum = 0;
        for (int i = igx - 1; i >= 1; i--) {
            sum += a[i];
            cnt++;
            // count when min * number of programmer greater or equal to x
            if (a[i] * cnt >= x) {
                ans++;
                sum = 0;
                cnt = 0;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
