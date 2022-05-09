package chapter03;

import java.util.Scanner;

public class UVA11195NQueensChess {
    private static int n;
    private static boolean[] row;
    private static boolean[] leftDiag;
    private static boolean[] rightDiag;
    private static int count;
    private static char[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = 0;
        while ((n = Integer.parseInt(scanner.nextLine())) != 0) {
            count = 0;
            row = new boolean[n];
            leftDiag = new boolean[2 * n - 1];
            rightDiag = new boolean[2 * n - 1];
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
            if ((board[tryRow][col] != '*') && !row[tryRow] && !leftDiag[tryRow - col + n - 1] && !rightDiag[tryRow + col]) {
                row[tryRow] = leftDiag[tryRow - col + n - 1] = rightDiag[tryRow + col] = true;
                backtrack(col + 1);
                row[tryRow] = leftDiag[tryRow - col + n - 1] = rightDiag[tryRow + col] = false;
            }
        }
    }
}
