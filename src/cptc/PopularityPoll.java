package cptc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PopularityPoll {
    int N;
    int M;
    Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if (o1.getValue() != o2.getValue()) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }
    };
    Map<String, Integer> candidates = new TreeMap<>();


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String row = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(row);

        for (int i = 0; i < N; i++) {
            candidates.put(tokenizer.nextToken(), 0);
        }

        M = Integer.parseInt(br.readLine());

        String name;
        Integer score;
        for (int i = 0; i < M; i++) {
            row = br.readLine();
            tokenizer = new StringTokenizer(row);
            name = tokenizer.nextToken();
            if (candidates.containsKey(name)) {
                score = Integer.parseInt(tokenizer.nextToken());
                Integer oldScore = candidates.get(name);
                oldScore+= score;
                candidates.put(name, oldScore + score);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        PopularityPoll m = new PopularityPoll();
        m.input();
        m.candidates.entrySet().stream().sorted(m.comparator).limit(3).
                forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }
}
