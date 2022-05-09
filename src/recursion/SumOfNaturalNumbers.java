package recursion;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(recursiveSummation(10000));
    }

    public static int recursiveSummation(int number) {
        if (number <= 1) {
            return number;
        }
        return number + recursiveSummation(number - 1);
    }
}
