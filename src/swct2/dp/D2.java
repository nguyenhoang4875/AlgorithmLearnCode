package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/D
 */
public class D2 {
    static int n;
    static StringTokenizer st;
    static long[] cnt = new long[(int) 1e5 + 5];
    static long[] dp = new long[(int) 1e5 + 5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x;
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(st.nextToken());
            cnt[x]++; // count time x appears
        }
        long maxI1 = cnt[1];
        long maxI2 = 0;
        long currentMax;

        for (int i = 2; i <= 100000; i++) {
            currentMax = Math.max(maxI1, i * cnt[i] + maxI2);
            maxI2 = maxI1;
            maxI1 = currentMax;
        }
        System.out.println(maxI1);
    }

}

