package codeforces.div2_848;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;
    static int[] a = new int[100010];

    static void solve() throws IOException {
        n = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        boolean hasTwoNeg = false;
        for (int i = 1; i <= n; i++) {
            a[i] = parseInt(st.nextToken());
            sum += a[i];
            if (i > 1 && a[i] == -1 && a[i - 1] == -1) hasTwoNeg = true;
        }

        int ans = 0;
        if (sum == n) {
            ans = n - 4;
        } else {
            if (hasTwoNeg) ans = sum + 4;
            else ans = sum;
        }
        println(ans);

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
