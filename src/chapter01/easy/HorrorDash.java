package chapter01.easy;

import java.util.Scanner;

public class HorrorDash {
    public static void horrorDash() {
        Scanner scanner = new Scanner(System.in);
        int totalCase = scanner.nextInt();
        int numCase = 0;
        while (totalCase-- > 0) {
            int len = scanner.nextInt();
            int max = scanner.nextInt();
            for (int i = 0; i < len - 1; i++) {
                int temp = scanner.nextInt();
                if (temp > max) {
                    max = temp;
                }
            }
            System.out.println("Case " + (++numCase) + ": " + max);
        }
    }
}
