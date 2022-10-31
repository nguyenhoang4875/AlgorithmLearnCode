package letcode.week313;

public class Main {
    public static void main(String[] args) {

        Main m = new Main();
//        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(m.maxSum(grid));
        System.out.println(m.minimizeXor(1, 12));
    }


    public int minimizeXor(int num1, int num2) {
        // rules of xor :1^1 = 0,1^0 = 1, 0^1 = 1, 0^0 = 0
        int a = Integer.bitCount(num1), b = Integer.bitCount(num2), res = num1;
        //if num1 == num2, num1 ^ num2 = 0 is the minimal XOR result
        // else if a>b we pick x  equals the bigger b bits of num1
        // so that we can XOR the bigger b bits of num1
        // and keep the smaller a-b bits left to make result small
        for (int i = 0; i < 32; i++) {
            // integer bound [-2^31, 2^31 - 1]
            if (a > b && ((1 << i) & num1) > 0) {
                // the latter means that 1<<i have at least 1's in the same position as num1
                // which means the res have 1 less 1 after xor
                res ^= 1 << i;
                a--;
            }
            // else if a<b we can first pick x = num1, and we still need
            //b-a more bits not in num1
            // we check from the smaller bits until x have b bits
            if (a < b && ((1 << i) & num1) == 0) {
                // the latter means that 1<<i and num1 have no 1's in the same position as num1
                // which means that the res would have more 1 after xor
                res ^= 1 << i;// the number of 1's in res need to plus 1
                a++;
            }
            // when a equals b, if-loop will not be entered
        }
        return res;
    }


    public int countBitSet(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int maxSum(int[][] grid) {
        int res = 0;
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r + 2 < m && c + 2 < n) {
                    res = 0;
                    for (int nr = r; nr <= r + 2; nr++) {
                        for (int nc = c; nc <= c + 2; nc++) {
                            res += grid[nr][nc];
                        }
                    }
                    res -= grid[r + 1][c];
                    res -= grid[r + 1][c + 2];
                    ans = Math.max(ans, res);
                }
            }
        }

        return ans;
    }
}
