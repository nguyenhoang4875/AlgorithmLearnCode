package chapter03;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * Let us look at a boring mathematics problem. :-)
 * We have three different integers, x, y and z, which satisfy the following three relations:
 * • x + y + z = A
 * • xyz = B
 * • x ^ 2 + y ^ 2 + z ^ 2 = C
 * You are asked to write a program that solves for x, y and z for given values of A, B and C.
 */
public class UVA11565SimpleEquations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCase = scanner.nextInt();
        while (totalCase-- > 0) {
            solution2(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

    }

    public static void solution1(int A, int B, int C) {
        boolean sol = false;
        int x, y, z;
        for (x = -100; x <= 100; x++) {

            for (y = -100; y <= 100; y++) {

                for (z = -100; z <= 100; z++) {
                    if (y != x && z != x && z != y && // all three must be different
                            x + y + z == A && x * y * z == B && x * x + y * y + z * z == C) {
                        if (!sol) {
                            System.out.printf("%d %d %d\n", x, y, z);
                            sol = true;
                        }
                    }
                }
            }
        }
        if (!sol) {
            System.out.println("No solution.");
        }
    }

    public static void solution2(int A, int B, int C) {
        boolean sol = false;
        int x, y, z;
        for (x = -22; x <= 22 && !sol; x++)
            if (x * x <= C)
                for (y = -100; y <= 100 && !sol; y++)
                    if (y != x && x * x + y * y <= C)
                        for (z = -100; z <= 100 && !sol; z++)
                            if (z != x && z != y &&
                                    x + y + z == A && x * y * z == B && x * x + y * y + z * z == C) {
                                System.out.printf("%d %d %d\n", x, y, z);
                                sol = true;
                            }
        if (!sol){
            System.out.println("No solution.");
        }
    }

}
