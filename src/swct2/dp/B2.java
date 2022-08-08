package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/B
 */
public class B2 {

    static Integer n, k;
    static Long[] a = new Long[(int) 2e5 + 5];
    static Long[] b = new Long[(int) 2e5 + 5];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Arrays.fill(a, 0,0,0L);
        a[0] = 0L;
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            a[i] += a[i - 1];
        }
        int z = 0;
        long t = Long.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            if (t > a[i] - a[i - k]) {
                t = a[i] - a[i - k];
                z = i;
            }
        }
        System.out.println(z - k + 1);

    }

}

