package codeforces.div3_847;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, s, r;
    static StringTokenizer st;

    static void solve() throws IOException {
        n = parseInt(br.readLine());
        int[] res = new int[n + 5];
        int[][] cnt = new int[n + 5][n + 5];
        int[][] src = new int[n + 5][n + 5];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n; j++) {
                src[i][j] = parseInt(st.nextToken());
                cnt[j][src[i][j]]++;
            }
        }

        // find first number.
        int firstNum = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[1][i] == n - 1) {
                firstNum = i;
                break;
            }
        }
        res[1] = firstNum;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (src[i][1] != firstNum) {
                index = i;
                break;
            }
        }

        for (int i = 2; i <= n; i++) {
            res[i] = src[index][i - 1];
        }

        for (int i = 1; i <= n; i++) {
            print(res[i] + " ");
        }
        println("");

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }

    static <T> void print(T t) {
        System.out.print(t);
    }
}