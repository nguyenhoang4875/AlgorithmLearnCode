package codeforces.dytechlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;
    static long l, r;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        l = Long.parseLong(st.nextToken());
        r = Long.parseLong(st.nextToken());
        long sl = (long) Math.sqrt(l);
        long sr = (long) Math.sqrt(r);

        long tmp = 0;
        long ans = 0;
        long tsl = sl + 1;
        long tsr = sr - 1;
        if (tsr > tsl) {
            ans += 3 * (tsr - tsl + 1);
            ans += 3;
            for (long i = sl * sl; i < l; i += sl) {
                ans--;
            }
            ans += 3;
            for (long i = sr * sr + 2 * sr; i > r; i -= sr) {
                ans--;
            }
        } else {
            for (long i = sl; i <= sr; i++) {
                for (int j = 0; j <= 2; j++) {
                    tmp = i * i + i * j;
                    if (tmp >= l && tmp <= r) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
