package codeforces.numbertheory;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, x, a, b, c;
    static StringTokenizer st;
    static int min = 0;


    static void solved() throws IOException {
        x = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        min = c + x;

        int tmp = min;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = x - 1; i >= 2; i--) {
            if (x % i == 0) {
                if (isPrime(i) && cnt1 == 0) {
                    tmp = a + x / i;
                    cnt1++;
                }
                if (!isPrime(i) && cnt2 == 0) {
                    tmp = b + x / i;
                    cnt2++;
                }
                min = Math.min(min, tmp);
                if (cnt1 >= 1 && cnt2 >= 1) {
                    System.out.println(min);
                    return;
                }
            }
        }

    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= (int) Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
