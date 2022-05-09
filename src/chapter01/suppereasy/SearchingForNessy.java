package chapter01.suppereasy;

import java.util.Scanner;

public class SearchingForNessy {
    public static void searchingForNessy() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int totalCase = scanner.nextInt();

        for (int i = 0; i < totalCase; i++) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            result.append((row / 3) * (column / 3));
            result.append(System.lineSeparator());
        }
        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
