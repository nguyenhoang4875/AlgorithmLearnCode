package codeforces.div4_827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Contest: https://codeforces.com/contest/1742
 */
public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] a = new int[110];
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i + 1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }

    }
}
