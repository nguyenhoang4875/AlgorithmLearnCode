package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/B
 */
public class B {

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
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        int index = 1;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        long min = sum;
        for (int i = 0; i < n - k; i++) {
            sum = sum + a[i + k] - a[i];
            if (min > sum) {
                min = sum;
                index = i + 2;
            }
        }

        System.out.println(index);
    }

}

