package codeforces.div4_849;

import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import java.io.*;
import java.util.*;

public class B {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;

    static void solve() throws IOException {
        n = parseInt(br.readLine());
        String cmd = " " + br.readLine();

        boolean found = false;
        int x = 0, y = 0;
        for (int i = 1; i <= n; i++) {
            switch (cmd.charAt(i)) {
                case 'U':
                    x++;
                    found = check(x, y);
                    break;
                case 'D':
                    x--;
                    found = check(x, y);
                    break;
                case 'R':
                    y++;
                    found = check(x, y);
                    break;
                case 'L':
                    y--;
                    found = check(x, y);
                    break;
            }
            if (found) break;
        }
        if (found) {
            println("YES");
        } else {
            println("NO");
        }

    }

    static boolean check(int x, int y) {
        return x == 1 && y == 1;
    }

    public static void main(String[] args) throws IOException {
//        tcs = 1;
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solve();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }
}