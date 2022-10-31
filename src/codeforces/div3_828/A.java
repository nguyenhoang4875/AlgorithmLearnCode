package codeforces.div3_828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Contest: https://codeforces.com/contest/1744
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static String s;
    static int[] a = new int[60];
    static StringTokenizer st;
    static char ans;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        s = " " + br.readLine();
        Map<Integer, Character> myMap = new HashMap<>();
        boolean check = true;
        for (int i = 1; i <= n; i++) {
            if (myMap.containsKey(a[i]) && s.charAt(i) != myMap.get(a[i])) {
                check = false;
                break;
            }
            myMap.put(a[i], s.charAt(i));
        }
        if (check) {
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
