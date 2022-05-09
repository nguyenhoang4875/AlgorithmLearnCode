package dynamicprograming.tabulation;

import java.util.Arrays;

public class CanConstructTub {

    public static void main(String[] args) {
        System.out.println(canConstructTub("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstructTub("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstructTub("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstructTub("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee",
                "eeeeeee"})); // false

    }

    public static boolean canConstructTub(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i < target.length(); i++) {
            if (table[i] == true) {
                for (String word : wordBank) {
                    if (target.startsWith(word, i)) {
                        table[i + word.length()] = true;
                    }
                }
            }

        }

        return table[target.length()];
    }
}

// Time: O(m^2*n)
// Space: O(m)
