package chapter01.suppereasy;

import java.util.Scanner;

public class RelationalOperator {
    public static void relationalOperator() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int totalCase = scanner.nextInt();
        int first;
        int second;
        for (int i = 0; i < totalCase; i++) {
            first = scanner.nextInt();
            second = scanner.nextInt();
            if (first < second) {
                result.append("<");

            } else if (first > second) {
                result.append(">");
            } else {
                result.append("=");
            }
            result.append(System.lineSeparator());
        }

        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
