package chapter01.easy;

import java.util.Scanner;

public class TariffPlan {
    public static void main(String[] args) {
        tariffPlant();
    }

    /**
     * Mile charges every 30 seconds at a rate of 10 cents
     * Juice charges every 60 seconds at a rate of 15 cents
     */

    private static void tariffPlant() {
        Scanner scanner = new Scanner(System.in);
        int totalCase = scanner.nextInt();
        int caseIndex = 0;
        while (totalCase-- > 0) {
            caseIndex++;
            int subCase = scanner.nextInt();
            int costMile = 0;
            int costJuice = 0;
            while (subCase-- > 0) {
                int time = scanner.nextInt() + 1;
                costMile += (time % 30 > 0) ? (time / 30 + 1) * 10 : time / 30 * 10;
                costJuice += (time % 60 > 0) ? (time / 60 + 1) * 15 : time / 60 * 15;
            }
            if (costMile == costJuice) {
                System.out.println("Case " + caseIndex + ": " + "Mile Juice " + costMile);
            } else if (costMile < costJuice) {
                System.out.println("Case " + caseIndex + ": " + "Mile " + costMile);
            } else {
                System.out.println("Case " + caseIndex + ": " + "Juice " + costJuice);
            }
        }

    }

}
