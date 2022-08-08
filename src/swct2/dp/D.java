package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/D
 */
public class D {
    static int n;
    static StringTokenizer st;
    static long[] cnt = new long[(int) 1e5 + 5];
    static long[] dp = new long[(int) 1e5 + 5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x;
        int maxI = -1;
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(st.nextToken());
            cnt[x]++; // count time x appears
            maxI = Math.max(maxI, x); // find max of array
        }

        dp[0] = 0; // get element value 0
        dp[1] = cnt[1]; // get element value 1
        for (int i = 2; i <= maxI; i++) {
            // get max when take element i vs i - 1
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + cnt[i] * i);

        }
        System.out.println(dp[maxI]);
    }

}

