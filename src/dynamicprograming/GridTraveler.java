package dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1));
        System.out.println(gridTraveler(2, 3));
        System.out.println(gridTraveler(3, 2));
        System.out.println(gridTraveler(3, 3));
//        System.out.println(gridTraveler(18, 18));
        System.out.println("-------------------------------------------------");
        System.out.println(gridTravelerMemorize(1, 1, new HashMap<>()));
        System.out.println(gridTravelerMemorize(2, 3, new HashMap<>()));
        System.out.println(gridTravelerMemorize(3, 2, new HashMap<>()));
        System.out.println(gridTravelerMemorize(3, 3, new HashMap<>()));
        System.out.println(gridTravelerMemorize(100, 100, new HashMap<>()));
    }

    public static long gridTraveler(long m, long n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

    public static long gridTravelerMemorize(long m, long n, Map<String, Long> memo) {
        String key = m + "," + n;

        // check if the key has been memorized
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        memo.put(key, gridTravelerMemorize(m - 1, n, memo) + gridTravelerMemorize(m, n - 1, memo));
        return memo.get(key);
    }
}
