package codeforces.div2_825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] a = new int[10005];
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int min = 100000;
        int imin = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (min > a[i]) {
                imin = i;
                min = a[i];
            }
        }
        if (n <= 2) {
            System.out.println("YES");
            return;
        }
        boolean check = true;
        if (imin != 1 && imin != n) check = false;
        for (int i = 1; i <= n; i++) {
            if (a[i] % min != 0) {
                check = false;
                break;
            }
        }
        if (!check) {
            System.out.println("NO");
        } else {
            if (imin == 1) {
                boolean asc = true;
                for (int i = 2; i <= n; i++) {
                    if (a[i - 1] > a[i]) asc = false;
                }
                if (asc) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            if (imin == n) {
                boolean desc = true;
                for (int i = 2; i <= n; i++) {
                    if (a[i - 1] < a[i]) desc = false;
                }
                if (desc) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
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
