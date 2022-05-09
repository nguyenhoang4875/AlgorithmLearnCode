package chapter01.easy;

import java.util.Scanner;

public class EasyPlanning {
    public static void main(String[] args) {
        easyPlanning();
    }

    public static void easyPlanning() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int people = scanner.nextInt();
            int budget = scanner.nextInt();
            int numHotels = scanner.nextInt();
            int numWeeks = scanner.nextInt();

            int minimumCost = budget + 1;
            while (numHotels-- > 0) {
                int price = scanner.nextInt();

                for (int j = 0; j < numWeeks; j++) {
                    if (scanner.nextInt() >= people && price * people <= minimumCost) {
                        minimumCost = price * people;
                    }
                }
            }

            if (minimumCost <= budget) {
                System.out.println(minimumCost);
            } else {
                System.out.println("stay home");
            }
        }
    }
}
