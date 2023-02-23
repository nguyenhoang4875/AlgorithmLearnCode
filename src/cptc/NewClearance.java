package cptc;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;

public class NewClearance {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] a = new int[100010];
    static int[][] cnt = new int[10][100010];
    static int[] hv = new int[10];
    static int n, m;
    static boolean[] used = new boolean[10];
    static StringTokenizer st;
    static int ans = (int)  2e9;

    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            a[i] = parseInt(st.nextToken());
            for (int j = 1; j <= m ; j++) {
                if(j == a[i]) {
                    cnt[j][i] = 1 + cnt[j][i-1];
                } else {
                    cnt[j][i] = cnt[j][i-1];
                }
            }
        }
        gen(1);
        println(ans);
    }

    static void gen(int s) {
        if(s > m) {
            int start = 0, end = 0;
            int sum = 0;
            for (int i = 1 ; i <= m ; i++) {
                int pro = hv[i];
                end = start + cnt[pro][n];
                int diff = cnt[pro][n] - (cnt[pro][end] - cnt[pro][start]);
                sum += diff;
                start = end;
            }
            ans = min(ans, sum);
        } else {
            for (int val = 1; val <= m; val++) {
                if(used[val]) continue;
                hv[s] = val;
                used[val] = true;
                gen(s +1);
                used[val] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solve();
    }
    static <T> void println(T t) {System.out.println(t);}
    static <T> void print(T t) {System.out.print(t);}
}

