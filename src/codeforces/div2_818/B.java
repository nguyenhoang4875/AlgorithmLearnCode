package codeforces.div2_818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1717
 * Editorial: https://codeforces.com/blog/entry/106553
 */
public class B {
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
            fillMap();
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

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (check(r, c)) {
                    map[r][c] = 'X';
                }
            }
        }
    }

    static boolean check(int nr, int nc) {
        return (nr + nc) % k == (r + c) % k;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
