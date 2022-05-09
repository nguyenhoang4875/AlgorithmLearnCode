package chapter01.medium;

import java.util.Scanner;

/**
 * 11507 Bender B. Rodr´iguez Problem
 * • ‘No’ if the wire isn’t bended at point (L − j, 0, 0).
 * • ‘+y’ if the wire is bended at point (L − j, 0, 0) on the +y axis.
 * • ‘-y’ if the wire is bended at point (L − j, 0, 0) on the -y axis.
 * • ‘+z’ if the wire is bended at point (L − j, 0, 0) on the +z axis.
 * • ‘-z’ if the wire is bended at point (L − j, 0, 0) on the -z axis.
 * Output: one line with the direction pointed by the last segment of the wire
 */

public class Bender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        int yDegrees;
        int zDegrees;
        boolean yFist = false;
        boolean zFist = false;
        while ((length = scanner.nextInt()) != 0) {
            System.out.println("length: " + length);

            yDegrees = 0;
            zDegrees = 0;
            while (length-- > 1) {
                String bending = scanner.next();
                System.out.println("bending is: " + bending);
                if (!bending.equals("No") && !yFist && !zFist) {
                    if (bending.substring(1).equals("y")) {
                        yFist = true;
                    } else {
                        zFist = true;
                    }
                }

                switch (bending) {
                    case "+y":
                        yDegrees += 90;
                        break;
                    case "-y":
                        yDegrees -= 90;
                        break;
                    case "+z":
                        zDegrees += 90;
                        break;
                    case "-z":
                        zDegrees -= 90;
                        break;
                    default:
                        break;
                }

            }

            System.out.println("yFirst: " + yFist);
            System.out.println("zFirst: " + zFist);
            yDegrees = yDegrees % 360;
            zDegrees = zDegrees % 360;
            yDegrees = (yDegrees + 360) % 360;
            zDegrees = (zDegrees + 360) % 360;

            System.out.println("yDegrees: " + yDegrees);
            System.out.println("zDegrees: " + zDegrees);

            if ((yDegrees == 0 && zDegrees == 0) || (yDegrees == 180 && zDegrees == 180)) {
                System.out.println("+x");
                //     break;
            }
            if ((yDegrees == 0 && zDegrees == 180) || (yDegrees == 180 && zDegrees == 0)) {
                System.out.println("-x");
                //    break;
            }

            if (yFist) {
                switch (yDegrees) {
                    case 0:
                        if (zDegrees == 90) {
                            System.out.println("+z");
                        } else if (zDegrees == 270) {
                            System.out.println("-z");
                        }
                        break;

                    case 90:
                        System.out.println("+y");
                        break;
                    case 180:
                        if (zDegrees == 90) {
                            System.out.println("-z");
                        } else if (zDegrees == 270) {
                            System.out.println("+z");
                        }
                        break;
                    case 270:
                        System.out.println("-y");
                        break;

                }
            } else {
                switch (zDegrees) {
                    case 0:
                        if (yDegrees == 90) {
                            System.out.println("+y");
                        } else if (yDegrees == 270) {
                            System.out.println("-y");
                        }
                        break;

                    case 90:
                        System.out.println("+z");
                        break;
                    case 180:
                        if (yDegrees == 90) {
                            System.out.println("-y");
                        } else if (yDegrees == 270) {
                            System.out.println("+y");
                        }
                        break;
                    case 270:
                        System.out.println("-z");
                        break;

                }
            }
        }
        System.out.println("----------");
    }
}
