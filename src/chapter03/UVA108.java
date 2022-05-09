package chapter03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UVA108 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("src/input_samples.txt"));
        int n;
        int maxSubRect, subRect;
        int[][] arr = new int[110][110];

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (j > 0) arr[i][j] += arr[i][j - 1];
            }
        }

        maxSubRect = -127 * 100 * 100;

        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                subRect = 0;

                for (int row = 0; row < n; row++) {
                    // Max 1D Range Sum on columns of this row  i
                    if (l > 0) subRect += arr[row][r] - arr[row][l - 1];
                    else subRect += arr[row][r];

                    // Kadane's algorithm on row
                    if (subRect < 0) subRect = 0;
                    maxSubRect = Math.max(maxSubRect, subRect);
                }
            }

        }

        System.out.printf("%d\n", maxSubRect);
    }

    ;
}
