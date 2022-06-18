package letcode.week294;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Week294 {

    /**
     * 2278. Percentage of Letter in String
     * https://leetcode.com/problems/percentage-of-letter-in-string/
     *
     * @param s
     * @param letter
     * @return the percentage of characters in s that equal letter rounded down to
     * the nearest whole percent.
     */
    public int percentageLetter(String s, char letter) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }

        return count * 100 / s.length();
    }

    /**
     * 2279. Maximum Bags With Full Capacity of Rocks
     * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
     *
     * @param capacity
     * @param rocks
     * @param additionalRocks
     * @return Return the maximum number of bags that could have full capacity
     * after placing the additional rocks in some bags.
     */
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        long sumNeedRocks;
        int answer = 0;
        long[] addToFullCapacity = new long[n];
        for (int i = 0; i < n; i++) {
            addToFullCapacity[i] = capacity[i] - rocks[i];
        }

        sumNeedRocks = Arrays.stream(addToFullCapacity).sum();
        if (additionalRocks >= sumNeedRocks) {
            answer = n;
        } else {
            Arrays.sort(addToFullCapacity);
            for (int i = 0; i < n; i++) {
                if (addToFullCapacity[i] == 0) {
                    answer++;
                } else {
                    additionalRocks -= addToFullCapacity[i];
                    if (additionalRocks >= 0) {
                        answer++;
                    } else {
                        break;
                    }
                }

            }
        }
        return answer;
    }

    public int minimumLines(int[][] stockPrices) {
        Integer n = stockPrices.length;

        if (n == 1) {
            return 0;
        }
        int answer = 1;
        long x1, x2, x3, y1, y2, y3, diff1, diff2;
        /*Sort 2D array with Comparator in Java 8*/
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        for (int i = 2; i < n; i++) {
            x1 = stockPrices[i][0];
            x2 = stockPrices[i - 1][0];
            x3 = stockPrices[i - 2][0];

            y1 = stockPrices[i][1];
            y2 = stockPrices[i - 1][1];
            y3 = stockPrices[i - 2][1];

            diff1 = (y3 - y2) * (x2 - x1);
            diff2 = (y2 - y1) * (x3 - x2);

            if (diff1 != diff2) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
       Integer[]  a = {1,5,6,7,3,2};
        System.out.println("Before sort:");
        System.out.println(Arrays.toString(a));
       Arrays.sort(a, Comparator.comparingInt(x -> x));
        System.out.println(Arrays.toString(a));
        Arrays.stream(a).reduce(0,(x,y) -> x+y);
    }

}
