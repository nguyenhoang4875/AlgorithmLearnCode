package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * TLE
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/F
 */
public class F1_TLE {
    static int n, q;
    static StringTokenizer st;
    static int l, r;
    static String s;
    static String subStr;
    static int[] cnt = new int[30]; // count time the letter appear

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        s = " " + br.readLine();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            Arrays.fill(cnt, 0);
            subStr = s.substring(l, r + 1);
            char c;
            for (int i = 0; i < subStr.length(); i++) {
                c = subStr.charAt(i);
                cnt[c - 'a' + 1]++; // increase count for the letter
            }

            long ans = 0;
            for (int i = 1; i <= 26; i++) {
                ans += (long) cnt[i] * i; // count length
            }
            System.out.println(ans);
        }
    }

}

