package codeforces.div2_829;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static String m;
    static StringTokenizer st;
    static int[] arr = new int[10000];
    static boolean[] check = new boolean[10000];
    static int cnt = 0;
    static int max = 0;
    static boolean pr = false;
    static int dis;

    static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        Arrays.fill(check, false);
        cnt = 0;
        max = 0;
        pr = false;
        dis = n / 2;
        arr[1] = dis;
        gen(2);
//        System.out.println("count = " + cnt);
        System.out.println("Max = " + max);

    }

    static void gen(int i) {
        if (i > n) {
            cnt++;
/*            for (int j = 1; j <= n ; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();*/
            int min = n;
            for (int k = 2; k <= n; k++) {
                min = min(min, abs(arr[k] - arr[k - 1]));
            }
            max = max(min, max);
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            pr = true;
        } else {
            for (int val = 1; val <= n; val++) {
                if (!check[val]) {
                    if (abs(val - arr[i - 1]) >= dis) {
                        arr[i] = val;
                        check[val] = true;
                        gen(i + 1);
                        check[val] = false;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }
}
