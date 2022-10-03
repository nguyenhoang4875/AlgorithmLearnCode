package codeforces.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, x;
    static int[] a = new int[100005];
    static StringTokenizer st;
    static long ans = 0;
    static final long MOD = 1000000007;


    static void solved() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ans = (binPow(2, n) * x - x) % MOD;
        System.out.println(ans);

    }

    static long binPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1)
                res = ((res % MOD) * (a % MOD)) % MOD;
            a = ((a % MOD) * (a % MOD)) % MOD;
            b /= 2;
        }
        return res % MOD;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
