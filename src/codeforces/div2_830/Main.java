package codeforces.div2_830;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, x;
    static int[] a = new int[25];
    static StringTokenizer st;
    static int[] dp = new int[500010];
    static Set<Long> set = new HashSet<>();
    static Map<Long, Long> map;

    static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        Long x;
        if (st.nextToken().equals("+")) {
            x = Long.parseLong(st.nextToken());
            set.add(x);
            updateMap(x);
        } else {
            x = Long.parseLong(st.nextToken());
            long ans = getAns(x);
            map.put(x, ans);
            System.out.println(ans);
        }
    }

    static Long getAns(long x) {
//        if (map.containsKey(x)) {
//            return map.get(x);
//        }
        long temp = x;
        while (set.contains(temp)) {
            temp += x;
        }
        return temp;
    }

    static void updateMap(long x) {


    }

    public static void main(String[] args) throws IOException {
//        tcs = 1;
        tcs = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        map = new HashMap<>();
        while (tcs-- > 0) {
            solve();
        }
    }
}
