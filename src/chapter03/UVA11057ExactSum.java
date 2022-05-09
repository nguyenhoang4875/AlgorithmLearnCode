package chapter03;

import java.util.Scanner;
import java.util.TreeSet;

public class UVA11057ExactSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder results = new StringBuilder();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            TreeSet<Integer> bookPrices = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                bookPrices.add(scanner.nextInt());
            }
            int money = scanner.nextInt();
            Integer bookI = bookPrices.floor(money / 2);
            Integer bookJ = bookPrices.ceiling(money / 2);

            while ((bookI + bookJ) != money) {
                if (bookI + bookJ > money) {
                    bookI = bookPrices.lower(bookI);
                } else {
                    bookJ = bookPrices.higher(bookJ);
                }
            }
            results.append(String.format("Peter should buy books whose prices are %d and %d.\n\n", bookI, bookJ));
        }
        results.setLength(results.length() - 1);
        System.out.println(results);
    }

}
