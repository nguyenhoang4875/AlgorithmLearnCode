package chapter03;

import java.util.Scanner;

public class UVA507JillRideAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tcs = scanner.nextInt();
        int n;
        int tc = 0;
        while (tcs-- > 0) {
            n = scanner.nextInt();
            int tmp = 1;
            int start = 1000000;
            int end = 0;
            int tempSum = 0;
            int ans = 0;

            for (int i = 2; i <= n; i++) {
                tempSum += scanner.nextInt();
                if (tempSum < 0 ){
                    tempSum = 0;
                    tmp = i;
                }
                if (tempSum >= ans) {
                    if (tempSum > ans ||  (i - tmp > end - start)) {
                        start = tmp;
                        end = i;
                    }
                    ans = tempSum;
                }
            }

            if (ans > 0) {
                System.out.printf("The nicest part of route %d is between stops %d and %d\n", ++tc, start, end);
            }
            else {
                System.out.printf("Route %d has no nice parts\n", ++tc);
            }
        }

    }
}
