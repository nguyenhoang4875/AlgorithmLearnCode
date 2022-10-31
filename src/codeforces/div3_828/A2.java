package codeforces.div3_828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Contest: https://codeforces.com/contest/1744
 */
public class A2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static String s;
    static int[] a = new int[60];
    static StringTokenizer st;
    static char ans;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        Set<Integer> sa = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sa.add(Integer.parseInt(st.nextToken()));
        }
        s = " " + br.readLine();
        Set<Character> ss = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            ss.add(s.charAt(i));
        }
        System.out.println("sa size = " + sa.size());
        System.out.println("ss size = " + ss.size());

        if (sa.size() >= ss.size()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
