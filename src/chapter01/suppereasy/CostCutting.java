package chapter01.suppereasy;

import java.util.Scanner;

public class CostCutting {
    public static void costCutting() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int totalCase = scanner.nextInt();
        int i = 0;
        while (totalCase-- != 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int max = a > b && a > c ? a : b > c ? b : c;
            int min = a < b && a < c ? a : b < c ? b : c;
            i++;
            result.append("Case " + i + ": " + ((a + b + c) - (min + max)));
            result.append(System.lineSeparator());
        }
        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
