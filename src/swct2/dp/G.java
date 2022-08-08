package swct2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/group/WjGLEK1J7U/contest/393194/problem/G
 */
public class G {
    static int tcs;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tcs = Integer.parseInt(br.readLine());
        String line;
        boolean isOne;
        boolean isTow;
        boolean isThree;
        while (tcs-- > 0) {
            isOne = false;
            isTow = false;
            isThree = false;
            int i1 = 0, i2 = 0, i3 = 0;
            int ans = Integer.MAX_VALUE;
            char c;
            int temp;
            line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                c = line.charAt(i);
                if (c == '1') {
                    isOne = true;
                    i1 = i;
                }
                if (c == '2') {
                    isTow = true;
                    i2 = i;
                }
                if (c == '3') {
                    isThree = true;
                    i3 = i;
                }

                if (isOne && isTow && isThree) {
                    // find the length contains 1,2,3
                    temp = Math.max(Math.max(i1, i2), i3) - Math.min(Math.min(i1, i2), i3);
                    ans = Math.min(ans, temp); // update the ans
                }

            }

            if (ans == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(ans + 1); // length need + 1
            }

        }
    }

}

