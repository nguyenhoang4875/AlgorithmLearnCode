package codeforces.div2_824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;
    static long n;
    static int[] a = new int[110];
    static StringTokenizer st;


    static void solved() throws IOException {
        n = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        int min = 100000000;
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, a[i]);
        }
        long ans = 0;
        int div = 2 * min - 1;
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] > div) {
                temp = a[i] / div;
                ans += (temp -1);
                if (temp * div != a[i]) {
                    ans += 1;
                }
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
