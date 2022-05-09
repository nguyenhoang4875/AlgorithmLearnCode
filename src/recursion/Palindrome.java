package recursion;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
    }

    public static boolean isPalindrome(String input) {
        // Define the base-case (stopping condition)
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        // Do some work to shrink the problem space
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }

        // Additional base-case to handle no-palindromes
        return false;
    }
}
