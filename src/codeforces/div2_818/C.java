package codeforces.div2_818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1717
 * Editorial: https://codeforces.com/blog/entry/106553
 */
public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] a = new int[200005];
    static int[] b = new int[200005];
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        a[n + 1] = a[1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        b[n + 1] = b[1];

        boolean c1 = true;
        for (int i = 1; i <= n; i++) {
            if (b[i] < a[i]) {
                c1 = false;
                break;
            }
        }
        if (!c1) {
            System.out.println("NO");
        } else {
            boolean c2 = true;
            for (int i = 1; i <= n; i++) {
                if (a[i] == b[i] || b[i] <= b[i + 1] + 1) continue;
                c2 = false;
                break;
            }
            if (c2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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
