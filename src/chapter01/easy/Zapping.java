package chapter01.easy;

import java.util.Scanner;

public class Zapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int one, two;
        while (first != -1 && second != -1) {
            if (first > second) {
                one = first - second;
                two = second + 100 - first;

            } else {
                one = second - first;
                two = first + 100 - second;
            }

            System.out.println(Math.min(one, two));
            first = scanner.nextInt();
            second = scanner.nextInt();

        }
    }
}
