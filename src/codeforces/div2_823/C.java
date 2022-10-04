package codeforces.div2_823;

import java.io.*;

/**
 * https://codeforces.com/contest/1730/problem/C
 */
public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;

    static void solved() throws Exception {
        StringBuilder sb = new StringBuilder(br.readLine());
        String s = sb.reverse().toString();
        char k = '9';
        int[] last = new int[10];

        for (char i : s.toCharArray()) {
            if (i <= k) {
                last[i - '0']++;
                k = i;
            } else {
                if (i != '9') {
                    last[i - '0' + 1]++;
                } else {
                    last[9]++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            while (last[i]-- > 0) {
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
