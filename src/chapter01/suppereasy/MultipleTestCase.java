package chapter01.suppereasy;

import utils.Utils;

import java.io.IOException;

public class MultipleTestCase {
    public static void main(String[] args) throws IOException {
        String source = Utils.readFileStream("src/input_sample.txt");
        String result = testCase2(source);
        Utils.writeFileStream(result, "src/output_sample.txt");

    }

    public static String testCase1(String source) {
        source = source.replaceAll("\n", " ");
        String[] nums = source.split(" ");
        int totalSet = Integer.parseInt(nums[0]);
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (totalSet-- > 0) {
            stringBuilder.append(Integer.parseInt(nums[i]) + Integer.parseInt(nums[i + 1]));
            stringBuilder.append(System.lineSeparator());
            i += 2;
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    public static String testCase2(String source) {
        String[] nums = source.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        int ans;
        for (int i = 0; i < nums.length; i++) {
            ans = 0;
            String[] set = nums[i].split(" +");
            int lenSet = Integer.parseInt(set[0]);
            for (int j = 1; j <= lenSet; j++) {
                ans += Integer.parseInt(set[j]);
            }
            stringBuilder.append(ans);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();

    }


}
