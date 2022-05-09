package utils;

import java.util.ArrayList;
import java.util.Comparator;

public class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, 5));
        pairs.add(new Pair(3, 5));
        pairs.add(new Pair(2, 6));
        pairs.add(new Pair(3, 4));
        pairs.add(new Pair(3, 6));

        pairs.forEach(System.out::println);
        System.out.println("-------------------------");
        pairs.sort(Comparator.comparingInt((Pair pair) -> pair.x).thenComparingInt( pai -> -pai.y));
        pairs.forEach(System.out::println);

    }

    @Override
    public String toString() {
        return "Pair{" + "x=" + x + ", y=" + y + '}';
    }
}
