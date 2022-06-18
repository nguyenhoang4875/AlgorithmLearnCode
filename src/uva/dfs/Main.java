package uva.dfs;
// 469 - Wetlands of Florida

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N;
    int M;
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    char[][] grid;
    boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.grid = new char[100][100];
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input_samples.txt")));
        StringBuilder result = new StringBuilder();
        int tcs = Integer.parseInt(br.readLine());
        br.readLine();
        while (tcs-- > 0) {
            m.N = 0;
            String row = br.readLine();
            m.M = row.length();
            m.grid[m.N++] = row.toCharArray();
            String str;
            int count = m.M -1;
            while ((str = br.readLine()).length() == m.M) {
                m.grid[m.N++] = str.toCharArray();
            }
            m.visited = new boolean[m.N][m.M];
            StringTokenizer st = new StringTokenizer(str);
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            result.append(m.dfs(i, j)).append("\n");

            while (br.ready() && (str = br.readLine()).length() > 0) {
                m.visited = new boolean[m.N][m.M];
                st = new StringTokenizer(str);
                i = Integer.parseInt(st.nextToken()) - 1;
                j = Integer.parseInt(st.nextToken()) - 1;
                result.append(m.dfs(i, j)).append("\n");
            }

            if (tcs > 0) {
                result.append("\n");
            }

        }
        System.out.println(result);


    }

    private int dfs(int i, int j) {
        visited[i][j] = true;
        int sum = 1;
        for (int k = 0; k < 8; k++) {
            if (isValid(i + dx[k], j + dy[k])) {
                sum += dfs(i + dx[k], j + dy[k]);
            }
        }
        return sum;
    }

    private boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= M || visited[i][j] || grid[i][j] == 'L') {
            return false;
        }
        return true;
    }

}
