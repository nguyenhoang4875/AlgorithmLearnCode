package chapter02;

import java.util.Scanner;

public class GreyCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCase = scanner.nextInt();
        while (totalCase-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int result = k ^ (k >> 1);
            System.out.println(result);
        }

    }
}
