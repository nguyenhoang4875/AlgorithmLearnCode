package chapter04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UVA11902Dominator {

    private static int[][] g = new int[105][105];
    private static int[][] f = new int[105][105];
    private static int[] used = new int[105];
    private static int n;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("src/input_samples.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int tcs, i, j, k;
        int tc = 0;
        tcs = sc.nextInt();

        while (tcs-- > 0) {
            n = sc.nextInt();

            // read data from file and fill to 2D array
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    g[i][j] = sc.nextInt();
                }
            }

            // fill all value not mark
            for (i = 0; i < n; i++) {
                used[i] = 0;
            }

            // check how many vertices in graph
//            dfs(0, -2);
            for (i = 0; i < n; i++) {
                used[i] = 1;
            }

            int[] fused = new int[105];

            for (i = 0; i < n; i++) {
                fused[i] = used[i];
            }

            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    used[j] = 0;
                }
                dfs(0, i);

                for (j = 0; j < n; j++) {
                    if (fused[j] > 0 && used[j] == 0) {
                        f[i][j] = 1;
                    } else {
                        f[i][j] = 0;
                    }
                }
                f[i][i] = fused[i];
            }
            // print the results with the correct format
            System.out.printf("Case %d:\n", ++tc);
            System.out.printf("+");
            for (i = -n + 1; i < n; i++) {
                System.out.printf("-");
            }
            System.out.printf("+\n");
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    System.out.printf("|");
                    System.out.printf(f[i][j] > 0 ? "Y" : "N");
                }
                System.out.printf("|\n");
                System.out.printf("+");
                for (j = -n + 1; j < n; j++) {
                    System.out.printf("-");
                }
                System.out.printf("+\n");
            }
        }

    }

    private static void dfs(int nd, int st) {
        if (nd == st) {
            return;
        }
        used[nd] = 1;
        for (int i = 0; i < n; i++) {
            if (g[nd][i] > 0 && used[i] == 0) {
                dfs(i, st);
            }
        }
    }
}
