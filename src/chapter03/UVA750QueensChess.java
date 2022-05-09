package chapter03;

public class UVA750QueensChess {
    private static int n = 14;
    private static int[] row = new int[n];
    private static int count;

    public static void main(String[] args) {
        backtrack(0);
    }

    public static boolean place(int col, int tryRow) {
        for (int prev = 0; prev < col; prev++) {
            if (tryRow == row[prev] || Math.abs(tryRow - row[prev]) == Math.abs(col - prev)) {
                return false;
            }
        }
        return true;
    }

    public static void backtrack(int col) {
        for (int tryRow = 0; tryRow < n; tryRow++) {
            if (place(col, tryRow)) {
                row[col] = tryRow;
                if (col == n - 1) {
                    System.out.printf("Case:%2d   ", ++count);
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%3d", row[i]);
                    }
                    System.out.println();
                } else {
                    backtrack(col + 1);
                }
            }
        }
    }
}
