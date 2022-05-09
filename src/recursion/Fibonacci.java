package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(8));
//        System.out.println(fibonacci(45));
        System.out.println(fibonacciMemorized(8, new HashMap<>()));
        System.out.println(fibonacciMemorized(100, new HashMap<>()));
        System.out.println(fibonacciTabulation(100));
    }

    public static long fibonacci(long n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacciMemorized(long n, Map<Long, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 0 || n == 1) {
            return n;
        }
        memo.put(n, fibonacciMemorized(n - 1, memo) + fibonacciMemorized(n - 2, memo));
        return memo.get(n);
    }

    public static long fibonacciTabulation(int n) {
        long[] table = new long[n + 2];
        Arrays.fill(table, 0);
        table[1] = 1;

        for (int i = 1; i < n; i++) {
            table[i + 1] += table[i];
            table[i + 2] += table[i];
        }

        return table[n];
    }
}
