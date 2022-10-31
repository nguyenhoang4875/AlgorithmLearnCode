package codeforces.edu_137_div2;

import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static char[] c = new char[200010];
    static int[] a = new int[200010];
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        String str = " " + br.readLine();
        for (int i = 1; i <= n; i++) {
            c[i] = str.charAt(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (c[i] == '0') {
                j = i;
            } else {
                if (j >= 1 && a[i] < a[j]) {
                    swap(i, j);
                    j = i;
                }
            }
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (c[i] == '1') sum += a[i];
        }
        System.out.println(sum);

    }

    static void swap(int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
