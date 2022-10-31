package codeforces.div2_830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, x;
    static int[] a = new int[25];
    static StringTokenizer st;
    static int[] dp = new int[500010];

    static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            if (a[1] == 1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            return;
        }

        int gcd = gcd(a[1], a[2]);
        for (int i = 3; i <= n; i++) {
            gcd = gcd(gcd, a[i]);
        }
        if (gcd == 1) {
            System.out.println(0);
            return;
        }
        int cnt = 1;
        if (gcd(gcd, n) == 1) {
            System.out.println(1);
        } else if (gcd(gcd, n - 1) == 1) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }

    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
//        tcs = 1;
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }
}
