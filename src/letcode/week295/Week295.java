package letcode.week295;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Week295 {
    public static void main(String[] args) {
/*
        Week295 m = new Week295();
        int[] arr = {10, 1, 2, 9, 1, 2, 3, 4};
        m.totalSteps(arr);

        int[][] arr2D = {{0, 1, 1}, {1, 1, 0}, {1, 1, 0}};
        int ans = m.minimumObstacles(arr2D);
        System.out.println("ans = " + ans);
*/
        boolean first = false;
        int[][] arr = {{1,2,3},{4,5,6}, {7,8,9}};
        for (int i = 0; i < 3; i++) {
            System.out.println("line" +i);
            for (int j = 0; j < 3; j++) {
               if (arr[i][j] == 5) {
                   first = true;
                   break;
               }
            }
            if (first){
                break;
            }
        }



    }

    public int totalSteps(int[] a) {
        int n = a.length;
        int res = 0;
        int j = -1;
        int dp[] = new int[n];
        int stack[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && a[i] > a[stack[j]]) {
                dp[i]++;
                dp[i] = Math.max(dp[i], dp[stack[j]]);
                j--;
                res = Math.max(res, dp[i]);
            }
            j++;
            stack[j] = i;
        }

//        System.out.println("res: " + res);
        return res;
    }

    public int minimumObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[row][col];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, grid[0][0]});
        int[][] keep = new int[row][col];
        keep[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            Arrays.fill(keep[i], Integer.MAX_VALUE);

        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            visited[node[0]][node[1]] = true;
            if (node[0] == row - 1 & node[1] == col - 1) return node[2];
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y]) {
                    continue;
                }

                int now = node[2];
                if (grid[x][y] == 1) {
                    now++;
                }
                if (now < keep[x][y]) {
                    keep[x][y] = now;
                    queue.offer(new int[]{x, y, now});
                }
            }
        }
        return -1;
    }
}
