package chapter01.medium;

import java.util.Scanner;

/**
 * H, U, D, and F
 * H is the height of the well in feet (H==0 end)
 * U is the distance in feet that snail can climb during the day.
 * D is the distance in feet that snail slides down during the night.
 * F is the fatigue factor expressed as a percentage.
 * success left the well
 * fail slide back to the bottom
 */
public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double h, u, d, f;
        double height;
        int day;
        while ((h = scanner.nextDouble()) != 0) {
            u = scanner.nextInt();
            d = scanner.nextInt();
            f = scanner.nextInt();
            height = 0;
            double fatigue_factor = u * f / 100;
            day = 0;
            while (true) {
                height += u;
                if (u > 0) u -= fatigue_factor;
                day++;
                if (height > h) {
                    System.out.println("success on day " + day);
                    break;
                }
                height -= d;
                if (height < 0) {
                    System.out.println("failure on day " + day);
                    break;
                }

            }
        }
    }
}
