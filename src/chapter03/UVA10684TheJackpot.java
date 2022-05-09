package chapter03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UVA10684TheJackpot {
    public static void main(String[] args) {
/*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("src/input_samples.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
        Scanner scanner = new Scanner(System.in);

        int n;
        while ((n = scanner.nextInt()) != 0) {
            int[] arr = new int[100000];
            int max = Integer.MIN_VALUE;
            int remainder = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                remainder += arr[i];
                if (remainder > max) {
                    max = remainder;
                }
                if (remainder < 0){
                    remainder = 0;
                }
            }
            if (max > 0) {
                System.out.printf("The maximum wining streak is %d.\n", max);
            } else {
                System.out.println("Losing streak.");
            }
        }
    }
}
