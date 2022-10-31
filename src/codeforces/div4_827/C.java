package codeforces.div4_827;

import static java.lang.Math.*;

import java.io.*;
import java.util.*;

/**
 * Contest: https://codeforces.com/contest/1742
 */
public class C {
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
            if (checkRow(i)) {
                System.out.println("R");
                return;
            }
            if (checkCol(i)) {
                System.out.println("B");
                return;
            }
        }
    }

    static boolean checkRow(int row) {
        // check row
        char first = map[row][1];
        if (first != 'R') return false;
        for (int c = 1; c <= n; c++) {
            if (map[row][c] != first) return false;
        }
        return true;
    }

    static boolean checkCol(int col) {
        char first = map[1][col];
        if (first != 'B') return false;
        for (int r = 1; r <= n; r++) {
            if (map[r][col] != first) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
