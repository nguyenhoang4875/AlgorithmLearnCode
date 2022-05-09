package chapter01.suppereasy;

import java.util.Scanner;

public class DivisionOfNlogonia {
    public static void DivisionOfNlogonia() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int totalCase = scanner.nextInt();
        while (totalCase != 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            while (totalCase-- > 0) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a == x || b == y)
                    result.append("divisa");
                else if (a > x && b > y)
                    result.append("NE");
                else if (a < x && b > y)
                    result.append("NO");
                else if (a < x && b < y)
                    result.append("SO");
                else
                    result.append("SE");
                result.append(System.lineSeparator());
            }

            totalCase = scanner.nextInt();

        }
        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
