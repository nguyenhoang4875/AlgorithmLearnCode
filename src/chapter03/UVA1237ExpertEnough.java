package chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA1237ExpertEnough {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        List<Branch> branches = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        while (totalCases-- > 0) {
            branches.clear();
            prices.clear();
            int totalBranches = scanner.nextInt();
            while (totalBranches-- > 0) {
                String name = scanner.next();
                Branch branch = new Branch(name, scanner.nextInt(), scanner.nextInt());
                branches.add(branch);
            }
            int totalPrices = scanner.nextInt();
            while (totalPrices-- > 0) {
                int price = scanner.nextInt();
                prices.add(price);
            }

            int count;
            for (Integer price : prices) {
                count = 0;
                int indexValidBranch = 0;
                for (int i = 0; i < branches.size(); i++) {
                    if (branches.get(i).isValidPrice(price)) {
                        count++;
                        indexValidBranch = i;
                    }
                }
                if (count == 1) {
                    System.out.println(branches.get(indexValidBranch).name);
                } else {
                    System.out.println("UNDETERMINED");
                }
            }
            if (totalCases > 0) System.out.println();
        }

    }

    public static class Branch {
        String name;
        int min;
        int max;

        public Branch(String name, int min, int max) {
            this.name = name;
            this.min = min;
            this.max = max;
        }

        public boolean isValidPrice(int price) {
            return price >= this.min && price <= this.max;
        }
    }

}
