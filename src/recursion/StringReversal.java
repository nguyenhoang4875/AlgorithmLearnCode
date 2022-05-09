package recursion;

public class StringReversal {

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));

    }

    public static String reverseString(String input) {
        if (input.equals("")) {
            return "";
        }
        // What is the smallest amount of work I can do each iteration?
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}
