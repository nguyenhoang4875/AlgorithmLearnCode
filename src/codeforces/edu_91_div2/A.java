package codeforces.edu_91_div2;

import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1380/problem/A
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;
    static int[] arr = new int[1010];

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int fistAfterDesc = 0;
        int fistAfterAsc = 0;
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                fistAfterDesc = i + 1;
                break;
            }
        }
        if (fistAfterDesc == 0) {
            System.out.println("NO");
            return;
        }

        for (int i = fistAfterDesc; i <= n - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                fistAfterAsc = i + 1;
                break;
            }
        }

        if (fistAfterAsc == 0) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        int t1 = fistAfterDesc - 1;
        int t2 = fistAfterAsc - 1;
        int t3 = fistAfterAsc;
        System.out.println(t1 + " " + t2 + " " + t3);

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) solved();
    }
}