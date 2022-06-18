package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Check {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(x -> System.out.printf("%2d", x));
        Collections.reverse(list);
        list.forEach(x -> System.out.printf("%2d", x));

    }
}
