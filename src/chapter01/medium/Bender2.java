package chapter01.medium;

import java.util.Scanner;

public class Bender2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L;
        String s;

        while (true) {
            L = Integer.parseInt(scanner.nextLine());

            if (L == 0) break;
            --L;

            int sign = 1;
            char c = 'x';

            for (int i = 0; i < L; ++i) {
                s = scanner.next();
                if (s.charAt(0) == 'N') continue;

                if (change(c, s.charAt(0), s.charAt(1))) sign = -sign;

                if (c == 'x') c = s.charAt(1);
                else if (c == 'y' && s.charAt(1) == 'y') c = 'x';
                else if (c == 'z' && s.charAt(1) == 'z') c = 'x';
            }
            System.out.printf("%c%c\n", sign == 1 ? '+' : '-', c);
            scanner.nextLine();

        }

    }

    public static boolean change(char cur, char c1, char c2) {
        if (cur == 'x' && c1 == '-') return true;
        if (cur == 'y' && c2 == 'y' && c1 == '+') return true;
        if (cur == 'z' && c2 == 'z' && c1 == '+') return true;
        return false;
    }
}
