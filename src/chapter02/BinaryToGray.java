package chapter02;

import java.util.Scanner;

public class BinaryToGray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCase = scanner.nextInt();
        while (totalCase-- > 0) {
            int n = scanner.nextInt();
            int res = n;
            n >>= 1;
            res ^= n;
            System.out.println(res);
        }
    }
}
