package codeforces.div2_824;

import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs;
    static long n;
    static StringTokenizer st;
    static String str;


    static void solved() throws IOException {
        n = Long.parseLong(br.readLine());
        str = br.readLine();
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        char c0 = str.charAt(0);
        boolean af = false;
        if (c0 == 'a') {
            map.put('a', 'b');
            af = true;
        } else {
            map.put(c0, 'a');
        }
        set.add(c0);
        char tmp = 'a';
        int index = 0;
        char c;
        boolean faa = true;
        for (int i = 1; i < n; i++) {
            c = str.charAt(i);
            if (!af) {
                if (!set.contains(c)) {
                    set.add(c);
                    index++;
                    map.put(c, (char) (tmp + index));
                }
            } else {
                if (faa) {
                    map.put(c, 'a');
                    index++;
                }
                index++;
                map.put(c, (char) (tmp + index));
                faa = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(str.charAt(i)));
        }
        System.out.println(sb);


    }


    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
