package codeforces.practices;

import static java.lang.Math.*;
import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/problemset/problem/1704/C
 */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, m;
    static int[] a = new int[100010];
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, 1, m + 1);
        // create length array
        Integer[] l = new Integer[m + 10];
        l[1] = a[1] - 1 + n - a[m];

        for (int i = 2; i <= m; i++) {
            l[i] = a[i] - a[i - 1] - 1;
        }

        if (m == 1) {
            System.out.println(2);
            return;
        }
        Arrays.sort(l, 1, m + 1, (a, b) -> b - a);
        int pro = 0;
        if (l[1] == 1) {
            pro = 1;
        }
        if (l[1] > 1) {
            pro = l[1] - 1;

            int cnt = 0;
            int index = 1;
            while (index < m) {
                cnt += 2;
                index++;
                l[index] -= 2 * cnt;
                if (l[index] <= 0) {
                    break;
                } else if (l[index] == 1) {
                    pro += 1;
                    break;
                } else {
                    pro += l[index] - 1;
                }
            }
        }
        System.out.println(n - pro);
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }

    }
}