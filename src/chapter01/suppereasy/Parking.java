package chapter01.suppereasy;

import java.util.Scanner;

public class Parking {
    public static void parking() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int totalCase = scanner.nextInt();
        for (int i = 0; i < totalCase; i++) {
            int min = 100;
            int max = 0;
            int temp;
            int length = scanner.nextInt();
            for (int j = 0; j < length; j++) {
                temp = scanner.nextInt();
                if (min > temp) {
                    min = temp;
                }
                if (max < temp) {
                    max = temp;
                }
            }
            result.append((max - min) * 2);
            result.append(System.lineSeparator());
        }

        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
