package codeforces.div2_818;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1717
 * Editorial: https://codeforces.com/blog/entry/106553
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, k, r, c;
    static StringTokenizer st;
    static char[][] map = new char[510][510];
    static int minx;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                map[r][c] = '.';
            }
        }
        minx = n / k;
        map[r][c] = 'X';
        if (minx == n) {
            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n; c++) {
                    map[r][c] = 'X';
                }
            }
        } else {
            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n; c++) {
                    if (check(r, c)) {
                        map[r][c] = 'X';
                    }

                }
            }
//            fillMap();
        }

        // print map
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }

    static void fillMap() {
//        for (int r = 1; r <= n; r++) {
//            for (int c = 1; c <= n; c++) {
//                if (checkRectangle(r, c)) {
//                    map[r][c] = 'X';
//                }
//            }
//        }
        for (int ir = r; ir >= 1; ir--) {
            for (int ic = 1; ic <= n; ic++) {
                if (checkRectangle(ir, ic)) {
                    map[ir][ic] = 'X';
                }
            }
        }
        for (int ir = r; ir <= n; ir++) {
            for (int ic = 1; ic <= n; ic++) {
                if (checkRectangle(ir, ic)) {
                    map[ir][ic] = 'X';
                }
            }
        }
    }

    static boolean check(int nr, int nc) {
        return (nr + nc) % k == (r + c) % k;
    }

    static boolean checkRectangle(int r, int c) {
        int min, max;
        int dis = k - 1;
        min = Math.max(1, r - dis);
        max = Math.min(n, r + dis);
        for (int nr = min; nr <= max; nr++) {
            if (map[nr][c] == 'X') return false;
        }
        min = Math.max(1, c - dis);
        max = Math.min(n, c + dis);
        for (int nc = min; nc <= max; nc++) {
            if (map[r][nc] == 'X') return false;
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
