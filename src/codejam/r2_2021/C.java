package codejam.r2_2021;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codejam.lge.com/problem/21395
 */
public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;
    static int[] primes;
    static int[] x = new int[100010];
    static final int SIZE_MAX = 10000;

    static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x, 1, n + 1);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < SIZE_MAX - n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += abs(x[j] - primes[j + i - 1]);
            }
            ans = min(ans, sum);
        }
        System.out.println(ans);

    }

    static void getPrimes() {
        primes = new int[SIZE_MAX];
        primes[1] = 2;
        int idx = 1;
        int n = 2;
        while (idx < SIZE_MAX) {
            boolean isPrime = true;
            for (int i = 1; i < idx; i++) {
                if (n % primes[i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[idx] = n;
                idx++;
            }
            n++;
        }
    }

    public static void main(String[] args) throws IOException {
        getPrimes();
        for (int i = 0; i < 20; i++) {
            System.out.print(primes[i] + " ");

        }
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }
}
