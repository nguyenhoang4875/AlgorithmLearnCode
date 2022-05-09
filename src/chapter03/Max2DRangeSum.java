package chapter03;

public class Max2DRangeSum {
    public static void main(String[] args) {
        int n = 4;

        int A[][] = new int[][]{
                {0, -2, -7, 0},
                {9, 2, -6, 2},
                {-4, 1, -4, 1},
                {-1, 8, 0, 2}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "  ");
            }
            System.out.println();
        }

        // sum the row i
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                A[i][j] += A[i][j - 1];
            }
        }

        int maxSubRect = -127 * 100 * 100;
        int subRect = 0;
        int l, r, row; // l,r: left and right column of sub rect

        for (l = 0; l < n; l++) {
            for (r = l; r < n; r++) {
                subRect = 0;
                for (row = 0; row < n; row++) {
                    // Max 1D Range Sum on columns of this row i
                    if (l > 0) subRect += A[row][r] - A[row][l - 1];
                    else subRect += A[row][r];

                    // Kadane's algorithms on rows
                    if (subRect < 0) subRect = 0;
                    maxSubRect = Math.max(maxSubRect, subRect);

                }
            }
        }

        System.out.println("Max 2D Range Sum: " + maxSubRect);
    }
}
