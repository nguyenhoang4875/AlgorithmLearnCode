package codeforces.div2_824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;
    static long n;
    static StringTokenizer st;


    static void solved() throws IOException {
        n = Long.parseLong(br.readLine());
        long a, b, c;
        n -= 3;
        n /= 3;

        System.out.println(n - 1);

    }


    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
