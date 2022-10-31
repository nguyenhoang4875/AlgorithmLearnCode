package codeforces.div4_827;

import static java.lang.Math.*;

import java.io.*;
import java.util.*;

/**
 * Contest: https://codeforces.com/contest/1742
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static char[][] map = new char[15][15];
    static StringTokenizer st;
    static char ans;

    static void solved() throws IOException {
        n = 8;
        br.readLine();
        for (int i = 1; i <= n; i++) {
            String str = " " + br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                System.out.println(ans);
                return;
            }
        }
    }

    static boolean check(int i) {
        // check row
        int cnt = 0;
        char first = map[i][1];
        if (first != '.') {
            for (int c = 1; c <= n; c++) {
                if (map[i][c] == first) cnt++;
            }
            if (cnt == n) {
                ans = first;
                return true;
            }
        }
        // check col
        cnt = 0;
        first = map[1][i];
        if (first != '.') {
            for (int r = 1; r <= n; r++) {
                if (map[r][i] == first) cnt++;
            }
            if (cnt == n) {
                ans = first;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
