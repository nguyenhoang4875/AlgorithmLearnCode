package codeforces.edu_134_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/**
 * Contest: https://codeforces.com/contest/1721
 */
public class B2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;
    static int n, m, x, y, d;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // check if end point valid
        if (n / 2 <= d || m / 2 <= d) {
            System.out.println(-1);
            return;
        }
        int dis = abs(n - x) + abs(m - y);
        if (dis <= d) {
            System.out.println(-1);
            return;
        }

        boolean cr = true;
        for (int i = 1; i <= n; i++) {
            dis = abs(i - x) + abs(m - y);
            if (dis <= d) {
                cr = false;
                break;
            }
        }

        boolean cc = true;
        for (int i = 1; i <= m; i++) {
            dis = abs(n - x) + abs(i - y);
            if (dis <= d) {
                cc = false;
                break;
            }
        }
        if (!cr && !cc) {
            System.out.println(-1);
        } else {
            System.out.println(n + m - 2);
        }

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }

    }
}
