package codeforces.div2_818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Only the following pairs of numbers are possible: (x,x), (x,2⋅x), and (x,3⋅x)
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;
    static String str;

    static void solved() throws IOException {
        long ans = 0;
        n = Integer.parseInt(br.readLine());
        ans += n;
        ans += n / 2 * 2;
        ans += n / 3 * 2;
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
