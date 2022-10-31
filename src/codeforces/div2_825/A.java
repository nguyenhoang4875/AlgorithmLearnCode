package codeforces.div2_825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] a = new int[110];
    static int[] b = new int[110];
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int ca1 = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] == 1) ca1++;
        }
        st = new StringTokenizer(br.readLine());
        int ca2 = 0;
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (b[i] == 1) ca2++;
        }

        boolean needO = false;
        int cntDiff = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] != b[i]) {
                needO = true;
                cntDiff++;
            }
        }
        if (!needO) {
            System.out.println(0);
            return;
        }
        int diff = Math.abs(ca1 - ca2);
        if (diff == 0) {
            System.out.println("1");
            return;
        }
        int ans = Math.min(cntDiff, diff + 1);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
