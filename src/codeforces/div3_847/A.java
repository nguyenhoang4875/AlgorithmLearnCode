package codeforces.div3_847;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import java.util.*;
import java.io.*;

public class A {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] pi = new int[]{0, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6,
            2, 6, 4, 3, 3, 8, 3, 2, 7};
    static StringTokenizer st;
    static Scanner sc = new Scanner(System.in);

    static void solve() throws IOException {
        String line = " " + br.readLine();
        n = line.length() - 1;
        int cnt = 0;
        for (int i = 1; i <= n ; i++) {
            if ((line.charAt(i) - '0') == pi[i]) {
                cnt++;
            }
            else {
                break;
            }
        }
        println(cnt);
    }

    public static void main(String[] args) throws IOException {
//        tcs = 1;
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }

}