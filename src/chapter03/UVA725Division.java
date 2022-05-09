package chapter03;

/**
 * Write a program that finds and displays all pairs of 5-digit numbers that between them use the digits 0
 * through 9 once each, such that the first number divided by the second is equal to an integer N,
 * where 2 ≤ N ≤ 79
 */
public class UVA725Division {
    public static void main(String[] args) {
        for (int i = 2; i < 71; i++) {
            division(i);
            System.out.println("----------------------------------------");
        }

    }

    private static void division(int n) {
        for (int fghij = 1234; fghij <= 98765 / n; fghij++) {
            int abcde = fghij * n;
            int tmp;
            int used = (fghij < 10000) ? 1 : 0;
            tmp = abcde;

            while (tmp > 0) {
                used = used | (1 << (tmp % 10));
                tmp /= 10;
            }

            tmp = fghij;
            while (tmp > 0) {
                used = used | (1 << (tmp % 10));
                tmp /= 10;
            }

            /**
             * Check is abcde and fghij are different digit.
             */
            if (used == (1 << 10) - 1) {
                System.out.printf(String.format("%05d / %05d = %d\n", abcde, fghij, n));
            }

        }
    }
}
