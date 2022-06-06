package cptc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Clearance {
    int N;
    int M;
    int answer;
    boolean[] mark = new boolean[10];
    int[] count = new int[10];
    int[] order = new int[10];
    int[] numbers;

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br =
//                new BufferedReader(new InputStreamReader(new FileInputStream("src/input_samples.txt")));
        String input = br.readLine();
        String[] row = input.split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);

        numbers = new int[N];

        String products = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(products);

        int temp;
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(tokenizer.nextToken());
            numbers[i] = temp;
            count[temp]++;
        }

    }

    public static void main(String[] args) throws IOException {
        Clearance m = new Clearance();

        m.input();
        m.answer = Integer.MAX_VALUE;
        m.generate(0);
        System.out.println(m.answer);
    }

    private void generate(int i) {
        if (i == M) {
            int temp = calculate();
            if (temp < answer) {
                answer = temp;
            }
            return;
        }

        for (int v = 0; v < M; v++) {
            if (!mark[v]) {
                mark[v] = true;
                order[i] = v;
                generate(i + 1);
                mark[v] = false;
            }

        }
    }

    private int calculate() {
        int result = 0;
        int pos = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < count[order[i]]; j++, pos++) {
                if (numbers[pos] != order[i]) result++;
            }
        }
        return result;
    }

}
