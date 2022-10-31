package codeforces.div4_827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Contest: https://codeforces.com/contest/1742
 */
public class E2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tcs, n, q;
    static int[] a = new int[200010];
    static int[] k = new int[200010];
    static int[] cnt = new int[200010];
    static int max = (int) 1e9 + 5;
    static StringTokenizer st;

    static void solved() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + a[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> a.getKey() - b.getKey());
        for (int i = 1; i < list.size(); i++) {
            list.get(i).setValue(list.get(i).getValue() + list.get(i - 1).getValue());
        }

        List<Integer> listKey = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listKey.add(list.get(i).getKey());
        }

        List<String> ans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int ansKey = list.size() - 1;
        for (int i = 1; i <= q; i++) {
            k[i] = Integer.parseInt(st.nextToken());

            // binary search find key
            int l = 0; int r = list.size() - 1;
            while (l <= r) {
                int mid = (l+r) / 2;
                if (listKey.get(mid) <= k[i]) {
                   ansKey = mid;
                   l = mid +1;
                } else {
                    r = mid -1;
                }
            }
            ans.add(list.get(ansKey).getValue()+"");
        }
        System.out.println(String.join(" ", ans));

    }


    public static void main(String[] args) throws IOException {
        tcs = Integer.parseInt(br.readLine());
        while (tcs-- > 0) {
            solved();
        }
    }
}
