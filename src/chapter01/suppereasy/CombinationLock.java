package chapter01.suppereasy;

import java.util.Scanner;

public class CombinationLock {
    public static void combinationLock() {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        int ans = 1080 + ((start - first + 40) % 40 + (second - first + 40) % 40 + (second - third + 40) % 40) * 9;
        System.out.println(ans);
    }
}
