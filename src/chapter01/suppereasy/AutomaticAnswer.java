package chapter01.suppereasy;

import java.util.Scanner;

public class AutomaticAnswer {
    public static void automaticAnswer() {

        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int totalCase = scanner.nextInt();
        while (totalCase-- != 0) {
            int n = scanner.nextInt();
            n = (315 * n + 36962) % 100 / 10;
            result.append(Math.abs(n));
            result.append(System.lineSeparator());

        }
        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
