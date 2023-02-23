package cptc;

import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.*;

public class PopularityPoll {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, Integer> mapName = new HashMap<>();
        int n = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            mapName.put(st.nextToken(), i);
        }
        HashMap<String, Integer> mapScore = new HashMap<>();
        int m = parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            if (mapName.containsKey(key)) {
                int val = parseInt(st.nextToken());
                mapScore.put(key, mapScore.getOrDefault(key, 0) + val);
            }
        }

        List<Node> ans = new ArrayList<>();
        for (String key : mapScore.keySet()) {
            Node node = new Node(key, mapName.get(key), mapScore.get(key));
            ans.add(node);
        }
        ans.sort((e1, e2) -> {
            if (e1.score == e2.score) return e1.id - e2.id;
            else return e2.score - e1.score;
        });
        for (int i = 0; i < 3; i++) {
            String str = ans.get(i).name + " " + ans.get(i).score;
            System.out.println(str);
        }

    }

    static class Node {
        String name;
        int id;
        int score;

        public Node(String name, int id, int score) {
            this.name = name;
            this.id = id;
            this.score = score;
        }
    }
}
