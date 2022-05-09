package chapter03;

import java.util.Scanner;

public class UVA12455Bars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        while (totalCases-- > 0) {
            int X = scanner.nextInt();
            int n = scanner.nextInt();
            int[] l = new int[n];
            for (int i = 0; i < n; i++) {
                l[i] = scanner.nextInt();
            }
            solution(n, l, X);
        }
    }

    public static void solution(int n, int[] l, int X) {
        int sum;
        boolean solved = false;

        // the main routine, variable ‘i’ (the bitmask) has been declared earlier
        for (int i = 0; i < (1 << n); i++) { // for each subset, O(2^n)
            sum = 0;

            for (int j = 0; j < n; j++) // check membership, O(n)
                if ((i & (1 << j)) > 0) // test if bit ‘j’ is turned on in subset ‘i’?
                    sum += l[j]; // if yes, process ‘j’
            if (sum == X) {
                solved = true;
                break; // the answer is found: bitmask ‘i’
            }
        }
        if (solved) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
