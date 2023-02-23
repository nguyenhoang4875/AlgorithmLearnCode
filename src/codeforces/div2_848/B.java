package codeforces.div2_848;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, m, d;
    static StringTokenizer st;
    static int[] a = new int[100010];
    static int[] p = new int[100010];

    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        d = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            a[i] = parseInt(st.nextToken());
        }

        int res = 0, pre = -1;
        for (int i = 0; i < m; i++) {
            int pos = -1;
            for (int j = 0; j < n; j++) {
                if (p[j] == a[i]) {
                    pos = j;
                    break;
                }
            }
            if (pre != -1) {
                if (pos <= pre) {
                    res += (pre - pos + d) / d;
                }
                pre = pos;
            } else {
                pre = pos;
            }
        }
        println(res);

    }

    public static void main(String[] args) throws IOException {
//        tcs = 1;
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }

    static <T> void println(T val) {
        System.out.println(val);
    }

    static <T> void print(T val) {
        System.out.print(val);
    }
}
