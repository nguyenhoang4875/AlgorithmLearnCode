package dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); //true
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));// false
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstructMemorize("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee",
                "eeeeeee"}, new HashMap<>()));
    }

    public static boolean canConstruct(String target, String[] wordBank) {
        if (target.equals("")) {
            return true;
        }

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, wordBank) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canConstructMemorize(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) {
            return true;
        }

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstructMemorize(suffix, wordBank, memo) == true) {
                    memo.put(target, true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }
}
