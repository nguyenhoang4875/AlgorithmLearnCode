package judge.chapter02;

import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;

    static void solve() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            n = parseInt(st.nextToken());
            int[] a = new int[n+5];
            for (int i = 0; i < n ;i++) {
                a[i] = parseInt(st.nextToken());
            }

            boolean check = isJolly(a, n);
            if (check) println("Jolly");
            else println("Not Jolly");
        }
    }

    static boolean isJolly(int a[], int n)
    {
        // Boolean vector to diffSet set of differences.
        // The vector is initialized as false.
        boolean []diffSet = new boolean[n];

        // Traverse all array elements
        for (int i = 0; i < n - 1 ; i++)
        {
            // Find absolute difference
            // between current two
            int d = Math.abs(a[i] - a[i + 1]);

            // If difference is out of range or repeated,
            // return false.
            if (d == 0 || d > n - 1 || diffSet[d])
                return false;

            // Set presence of d in set.
            diffSet[d] = true;
        }
        return true;
    }

    static boolean check(int x, int y) {
        return x == 1 && y == 1;
    }

    public static void main(String[] args) throws IOException {
//        int n = 7;
//        int[] a = {0, 1, 2,2, 2, 1, 2, 1};
//        int[][] cnt = new int[3][10];
//        for (int i = 1; i <= n ; i++) {
//        //    cnt[a[i]][i] = 1 + cnt[a[i]][i-1];
//            for (int j = 1; j <= 2; j++) {
//                if (a[i] == j) {
//                    cnt[j][i] = 1 + cnt[j][i-1];
//                } else {
//                    cnt[j][i] = cnt[j][i-1];
//                }
//            }
//        }
//        println(Arrays.deepToString(cnt));
//        tcs = 1;
////        tcs = Integer.parseInt(br.readLine());
//        while (tcs-- > 0) {
//            solve();
//        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }

    static <T> void print(T t) {
        System.out.print(t);
    }
}
