package chapter02;

import java.util.Scanner;
import java.util.Vector;

public class JustFinish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCase = scanner.nextInt();
        int numCase = 0;
        while (numCase++ < totalCase) {
            int n = scanner.nextInt();
            int len = 0;
            Vector<Integer> gallonAvailable = new Vector<>();
            Vector<Integer> gallonNeed = new Vector<>();

            while (len++ < n) {
                gallonAvailable.add(scanner.nextInt());
            }
            len = 0;

            while (len++ < n) {
                gallonNeed.add(scanner.nextInt());
            }
            int startID = 0;

            while (startID < n) {
                int start = startID;
                int res = 0;
                int step;
                for (step = 0; step < n; step++) {
                    if (res + gallonAvailable.get(start) - gallonNeed.get(start) < 0) {
                        break;
                    } else {
                        res += gallonAvailable.get(start) - gallonNeed.get(start);
                        start = (start + 1) % n;
                    }
                }
                if (step == n) {
                    break;
                } else {
                    startID += step + 1;
                }
            }
            System.out.print("Case " + numCase + ": ");
            if (startID < n) {
                System.out.println("Possible from station " + (startID + 1));
            } else {
                System.out.println("Not possible");
            }

        }
    }
}
