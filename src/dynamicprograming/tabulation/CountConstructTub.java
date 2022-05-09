package dynamicprograming.tabulation;

import java.util.Arrays;

public class CountConstructTub {
    public static void main(String[] args) {
        System.out.println(countConstructTub("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); // 2
        System.out.println(countConstructTub("abcdef", new String[]{"ab", "abc", "cd", "def", "adbc"})); // 1
        System.out.println(countConstructTub("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0
        System.out.println(countConstructTub("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // 4
        System.out.println(countConstructTub("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee",
                "eeeeeeeeeeee"})); // 0
    }

    public static int countConstructTub(String target, String[] wordBank) {
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i < target.length(); i++) {
            for (String word : wordBank) {
                if (target.startsWith(word, i)) {
                    table[i + word.length()] += table[i];
                }

            }
        }

        return table[target.length()];
    }
}

// m = target.length, n = wordBank.length
// Time: O(n*m)
// Space: (m)
