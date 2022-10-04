package codeforces.div2_823;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1730/problem/A
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, c;
    static StringTokenizer st;
    static int[] cnt = new int[110];


    static void solved() throws Exception {
        Arrays.fill(cnt, 0);
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int x;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x = Integer.parseInt(st.nextToken());
            cnt[x]++;
        }
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] > 0) {
                if (cnt[i] >= c) {
                    ans += c;
                } else {
                    ans += cnt[i];
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }

}
