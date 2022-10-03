package codeforces.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, x;
    static int[] a = new int[100005];
    static StringTokenizer st;
    static long ans = 0;
    static final long MOD = 1000000007;
    static int minDiv = 0;
    static int maxGcd = 0;


    static void solved() throws IOException {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cnt = new int[1000000];
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            set.add(a[i]);
            cnt[a[i]]++;
        }
        Arrays.sort(a, 1, n + 1);

        int tmp;
        maxGcd = 0;
        int iMax = 0;
        for (int i = 1; i <= n; i++) {
            if (!isPrime(a[i])) {
                tmp = a[i] / minDiv;
                if (set.contains(tmp)) {
                    if (maxGcd < tmp) {
                        maxGcd = tmp;
                        iMax = i;
                    }
                }
            }
        }

        int len = 0;
        for (int i = iMax; i <= n; i++) {
            if (a[i] % maxGcd == 0) {
                len += cnt[a[i]];
            }
        }
        System.out.println(maxGcd + " " + len);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 3; i <= (int) Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) {
                minDiv = i;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
