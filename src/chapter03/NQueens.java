package chapter03;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] row = new int[n];
        backtrack(results, row, n, 0);
        return results;
    }

    public boolean place(int[] row, int col, int tryRow) {
        for (int prev = 0; prev < col; prev++) {
            if (row[prev] == tryRow || Math.abs(row[prev] - tryRow) == Math.abs(prev - col)) {
                return false;
            }
        }
        return true;
    }

    public void backtrack(List<List<String>> results, int[] row, int n, int col) {
        for (int tryRow = 0; tryRow < n; tryRow++) {
            if (place(row, col, tryRow)) {
                row[col] = tryRow;
                List<String> temp = new ArrayList<>();
                String line = "";
                if (col == (n - 1)) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (row[i] == j) {
                                line = line + "Q";
                            } else {
                                line = line + ".";
                            }
                        }
                        temp.add(line);
                        line = "";
                    }
                    results.add(temp);
                } else {
                    backtrack(results, row, n, col + 1);
                }
            }
        }
    }
}
