package chapter01.easy;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RobotInstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCase = Integer.parseInt(scanner.nextLine());
        while (totalCase-- > 0) {
            int totalStep = Integer.parseInt(scanner.nextLine());
            int[] steps = new int[totalStep];
            for (int i = 0; i < totalStep; i++) {
                String go = scanner.nextLine();
                if (go.equals("LEFT")) {
                    steps[i] = -1;
                } else if (go.equals("RIGHT")) {
                    steps[i] = 1;
                } else {
                    int temp = Integer.parseInt(go.substring(go.length() - 1));
                    steps[i] = steps[temp - 1];
                }
            }
            System.out.println(IntStream.of(steps).sum());
        }
    }

}
