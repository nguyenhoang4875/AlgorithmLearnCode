package dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); // 2
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "adbc"})); // 1
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // 4
        System.out.println(countConstructMemorize("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee",
                "eeeeeeeeeeee"}, new HashMap<>())); // 0

    }


    public static int countConstruct(String target, String[] wordBank) {
        if (target.equals("")) return 1;

        int totalCount = 0;

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int numWaysForRest = countConstruct(suffix, wordBank);
                totalCount += numWaysForRest;
            }

        }

        return totalCount;
    }

    public static int countConstructMemorize(String target, String[] wordBank, Map<String, Integer> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) return 1;

        int totalCount = 0;

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int numWaysForRest = countConstructMemorize(suffix, wordBank, memo);
                totalCount += numWaysForRest;
            }

        }

        memo.put(target, totalCount);
        return totalCount;
    }

}

// Brute force
// Time: O(n^m * m)
// Space: O(m^2)

// Memorized
// Time: O(n*m^2)
// Space: (m^2)

