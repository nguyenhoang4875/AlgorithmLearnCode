package recursion;

public class TailCallRecursion {

    public static void main(String[] args) {
        System.out.println(factorial(20));
        System.out.println(factorial2(20));

    }

    public static long factorial2(long x) {
        if (x > 0) {
            return x * factorial2(x - 1);
        }
        return 1;
    }

    public static long factorial(long x) {
        return tailFactorial(x, 1);
    }

    private static long tailFactorial(long x, long multiplier) {
        if (x > 0) {
            return tailFactorial(x - 1, x * multiplier);
        }
        return multiplier;
    }
}
