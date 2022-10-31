package codeforces.round23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, k;
    static int[] a = new int[55];
    static int min = 0;
    static StringTokenizer st;


    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean hasOne = false;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] == 1) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
