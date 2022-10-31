package codeforces.edu_137_div2;

import static java.lang.Math.*;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n;
    static StringTokenizer st;

    static void solved() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int rm = set.size();
        if (rm == 8) {
            System.out.println(6);
            return;
        }
        int res = 10 - rm;
        System.out.println(res * (res - 1) * 3);


    }

    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
