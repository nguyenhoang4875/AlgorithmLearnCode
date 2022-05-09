package chapter03;

import java.util.Scanner;

public class UVA10976FractionAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k;
        StringBuilder results;
        int count;
        while (scanner.hasNext() && (k = scanner.nextInt()) > 0) {
            results = new StringBuilder();
            count = 0;
            int y;
            for (y = k + 1; y <= 2 * k; y++) {
                double x = (double) (y * k) / (y - k);
                if (x == (int) x) {
                    results.append(String.format("1/%d = 1/%d + 1/%d\n",k,(int)x,y));
                    count++;
                }
            }
            System.out.println(count);
            System.out.print(results);
        }
    }
}
