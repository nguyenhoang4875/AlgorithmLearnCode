package chapter03;

public class Max1DRangeSum {
    public static void main(String[] args) {
        int n = 9, A[] = {4, -5, 4, -3, 4, 4, -4, 4, -5};   // a sample array A
        int maxRange = Integer.MIN_VALUE;
        int maxRangeCurrent = 0;
        for (int i = 0; i < n; i++) {
            maxRangeCurrent += A[i];
            if (maxRangeCurrent > 0) {
                if (maxRange < maxRangeCurrent) maxRange = maxRangeCurrent;
                //maxRange = Math.max(maxRangeCurrent, maxRange);

            } else {
                maxRangeCurrent = 0;
            }
        }
        System.out.println(maxRange);
    }
}
