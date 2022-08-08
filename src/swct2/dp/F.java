package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/F
 */
public class F {
    static int n, q;
    static StringTokenizer st;
    static int l, r;
    static String s;
    static String subStr;
    static int[] cnt = new int[30]; // count time the letter appear
    static long[] dp = new long[(int) 1e5 + 5]; // save the length to index of letter i

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        s = " " + br.readLine();
        char c;
        Arrays.fill(dp, 0, n + 1, 0L);
        for (int i = 1; i <= n; i++) {
            c = s.charAt(i);
            dp[i] = dp[i - 1] + (long) (c - 'a' + 1);
        }


        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            long ans = dp[r] - dp[l - 1]; // count the length of substring
            System.out.println(ans);

        }
    }

}

