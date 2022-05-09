package chapter03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UVA11292TheDragonOfLoowater {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/input_samples.txt"));
        int heads;
        int knights;
        ArrayList<Integer> headList = new ArrayList<>();
        ArrayList<Integer> knightList = new ArrayList<>();
        int minCoin;

        while ((heads = scanner.nextInt()) != 0 && (knights = scanner.nextInt()) != 0) {
            if (knights < heads) {
                System.out.println("Loowater is doomed!");
                for (int i = 0; i < knights + heads; i++) {
                    scanner.nextInt();
                }
                continue;
            } else {
                headList.clear();
                knightList.clear();
                minCoin = 0;
                for (int i = 0; i < heads; i++) {
                    headList.add(scanner.nextInt());
                }
                for (int i = 0; i < knights; i++) {
                    knightList.add(scanner.nextInt());
                }
                headList.sort(Integer::compareTo);
                knightList.sort(Integer::compareTo);
                int headIndex;
                int knightIndex;
                for (headIndex = 0, knightIndex = 0; headIndex < heads && knightIndex < knights;
                     headIndex++, knightIndex++) {
                    int tempHead = headList.get(headIndex);
                    int tempKnight = knightList.get(knightIndex);

                    while (tempKnight < tempHead) {
                        tempKnight = knightList.get(++knightIndex);
                    }
                    minCoin += tempKnight;
                }
                if (headIndex == heads) {
                    System.out.println(minCoin);
                } else {
                    System.out.println("Loowater is doomed!");
                }
            }
        }
    }
}
