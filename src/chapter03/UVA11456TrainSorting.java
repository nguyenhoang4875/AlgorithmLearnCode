package chapter03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Using dynamic programming top down
 */

public class UVA11456TrainSorting {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);

        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("src/input_samples.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int tcs = sc.nextInt();
        int[] arr = new int[2500];
        int[] ma = new int[2500];
        int[] mb = new int[2500];
        int n;

        while (tcs-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // for n-1 to 0 because we need to reuse the value of higher index in array ma,mb
            // that had been calculate before
            for (int i = n - 1; i >= 0; i--) {
                ma[i] = 1;
                mb[i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] < arr[j]) {
                        ma[i] = Math.max(ma[i], ma[j] + 1);
                    } else {
                        mb[i] = Math.max(mb[i], mb[j] + 1);
                    }
                }

            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, ma[i] + mb[i] - 1);
            }
            System.out.println(ans);
        }
    }
}
