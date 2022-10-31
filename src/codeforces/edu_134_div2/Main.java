package codeforces.edu_134_div2;

import java.io.*;
import java.util.*;

/**
 * Contest: https://codeforces.com/contest/1721
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static int[] a = new int[200005];
    static int[] b = new int[200005];
    static int[] dmn = new int[200005];
    static int[] dmx = new int[200005];
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int index = 1;
        for (int i = 1; i <= n; i++) {
            if (b[index] < a[i]) {
                while (b[index] < a[i]) {
                    index++;
                }
            }
            dmn[i] = b[index] - a[i];
        }

        for (int i = 1; i <= n ; i++) {
            dmx[i] = b[n] - a[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dmn[i]).append(" ");
        }
        System.out.println(sb);
        sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dmx[i]).append(" ");
        }
        System.out.println(sb);


    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }

    }
}
