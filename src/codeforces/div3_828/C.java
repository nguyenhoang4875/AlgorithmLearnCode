package codeforces.div3_828;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Contest: https://codeforces.com/contest/1744
 */
public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static String s;
    static char c;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = st.nextToken().charAt(0);
        s = br.readLine();
        s = s;
        if (c == 'g') {
            System.out.println(0);
            return;
        }
        List<Integer> gs = new ArrayList<>();
        List<Integer> cs = new ArrayList<>();
        int cg = 0;
        int cc = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'g') {
                gs.add(i);
                cg++;
            }
            if (s.charAt(i) == c) {
                cs.add(i);
                cc++;
            }
        }
        int ans = 0;
        int index = 0;
        for (int ic : cs) {
            while (index < gs.size() && gs.get(index) < ic) {
                index++;
            }
            if (index == gs.size() && gs.get(cg - 1) < cs.get(cc - 1)) {
                ans = max(ans, gs.get(0) + n - ic);
            } else {
                ans = max(ans, gs.get(index) - ic);
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
