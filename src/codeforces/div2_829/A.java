package codeforces.div2_829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static String m;
    static StringTokenizer st;

    static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = br.readLine();
        int q = 0, a = 0;
        int cq = 0, ca = 0;
        if (m.charAt(n-1) == 'Q') {
            System.out.println("NO");
            return;
        }
        for (int i = n -1; i >= 0; i--) {
            if (m.charAt(i) == 'Q') {
                cq++;
            } else {
                ca++;
            }
            if (cq > ca) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }
}
