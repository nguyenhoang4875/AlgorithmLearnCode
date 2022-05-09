package swpctc.hw02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Workout {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream("src/input_samples.txt"));
        int tcs = scanner.nextInt();
        int tc = 0;
        while (tc++ < tcs) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.printf("Case: #%d: %d\n", tc, workout(n, nums, k));
            workout(n, nums, k);
        }

    }

    public static int workout(int n, int[] nums, int k) {
        Integer[] subs = new Integer[n - 1];
        for (int i = 0; i < n - 1; i++) {
            subs[i] = nums[i + 1] - nums[i];
        }
        if (subs.length == 1) {
            return (int)Math.ceil(subs[0]*1.0f/(k+1));
        }
        Arrays.sort(subs, Collections.reverseOrder());
//        System.out.println(Arrays.toString(subs));
        int kTemp = 0;
        while (k > 0) {
            kTemp = k;
            float divide = 2f;
            while ((int) Math.ceil(subs[0] / divide) > subs[1]) {
                divide++;
                kTemp--;
                if (kTemp == 0) {
                    subs[0] = (int) Math.ceil(subs[0] / divide);
                    break;
                }
            }

            subs[0] = (int) Math.ceil(subs[0] / divide);
            k = k - (int) divide + 1;
            Arrays.sort(subs, Collections.reverseOrder());
//            System.out.println("***********************");

        }
        return subs[0];
    }

}
