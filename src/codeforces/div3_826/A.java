package codeforces.div3_826;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1741
 */
public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static String a, b;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = st.nextToken();
        // S = 83, M = 77, L = 76
        char eoa = a.charAt(a.length() - 1);
        char eob = b.charAt(b.length() - 1);
        if (a.equals(b)) {
            System.out.println("=");
            return;
        }
        if (eoa > eob) {
            System.out.println("<");
        } else if (eoa < eob) {
            System.out.println(">");
        } else {
            if (eoa == 'S') {
                if (a.length() < b.length()) {
                    System.out.println(">");
                } else {
                    System.out.println("<");
                }
            } else {
                if (a.length() < b.length()) {
                    System.out.println("<");
                } else {
                    System.out.println(">");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
