package letcode.week293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {
    public static void main(String[] args) {
        FindResultantArrayAfterRemovingAnagrams m = new FindResultantArrayAfterRemovingAnagrams();
        int bottom = 28;
        int top = 50;
        int[] special = {35, 48};
        System.out.println(m.maxConsecutive(bottom, top, special));

    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (ans.isEmpty() || !isAnagrams(word, ans.get(ans.size() - 1))) {
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1C = s1.toCharArray();
        char[] s2C = s2.toCharArray();
        Arrays.sort(s1C);
        Arrays.sort(s2C);
        String s1Sort = new String(s1C);
        String s2Sort = new String(s2C);
        return s1Sort.equals(s2Sort);
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int first = special[0] - bottom;
        int last = top - special[special.length - 1];
        int maxFloor = first;
        int temp;
        for (int i = 0; i < special.length - 1; i++) {
            temp = special[i + 1] - special[i] - 1;
            if (temp > maxFloor) {
                maxFloor = temp;
            }
        }
        maxFloor = Math.max(maxFloor, last);
        return maxFloor;
    }
}
