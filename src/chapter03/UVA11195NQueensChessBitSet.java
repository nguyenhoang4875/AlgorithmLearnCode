package chapter03;

import java.util.*;

public class UVA11195NQueensChessBitSet {
    private static int n;
    private static BitSet row;
    private static BitSet leftDiag;
    private static BitSet rightDiag;
    private static int count;
    private static char[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = 0;
        while ((n = Integer.parseInt(scanner.nextLine())) != 0) {
            count = 0;
            row = new BitSet(n);
            leftDiag = new BitSet(2 * n - 1);
            rightDiag = new BitSet(2 * n - 1);
            board = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            backtrack(0);
            System.out.printf("Case %d: %d\n", ++testcase, count);
        }

    }


    public static void backtrack(int col) {
        if (col == n) {
            count++;
            return;
        }

        for (int tryRow = 0; tryRow < n; tryRow++) {
            if ((board[tryRow][col] != '*') && !row.get(tryRow) && !leftDiag.get(tryRow - col + n - 1) && !rightDiag.get(tryRow + col)) {

                row.set(tryRow);
                leftDiag.set(tryRow-col+n-1);
                rightDiag.set(tryRow+col);
                backtrack(col + 1);
                row.clear(tryRow);
                leftDiag.clear(tryRow-col+n-1);
                rightDiag.clear(tryRow+col);
            }
        }
    }
}
