package chapter02;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FalseCoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        while (testCaseCount-- > 0) {
            scanner.nextLine();
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            boolean[] flag = new boolean[C];

            while (N-- > 0) {
                String s = scanner.nextLine();
                st = new StringTokenizer(s);
                //         st.nextToken();
                int total = st.countTokens();

                if (scanner.nextLine().charAt(0) == '=') {
                    for (int i = 0; i < total; i++) {
                        flag[Integer.parseInt(st.nextToken()) - 1] = true;
                    }
                }
            }

            int zeroCount = 0;
            int index = -1;

            for (int i = 0; i < flag.length; i++) {
                if (!flag[i]) {
                    zeroCount++;
                    index = i + 1;
                }
            }

            if (zeroCount == 1) System.out.println(index);
            else System.out.println(0);

            if (testCaseCount != 0) System.out.println();
        }
    }
}
