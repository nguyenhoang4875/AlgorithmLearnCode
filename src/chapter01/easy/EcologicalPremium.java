package chapter01.easy;

import java.util.Scanner;

public class EcologicalPremium {
    public static void ecologicalPremium() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        int totalCase = scanner.nextInt();
        int sum;
        while (totalCase-- > 0) {
            int set = scanner.nextInt();
            int a;
            int b;
            int c;
            sum = 0;
            while (set-- > 0) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                sum += a * c;
            }
            result.append(sum);
            result.append(System.lineSeparator());
        }
        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
