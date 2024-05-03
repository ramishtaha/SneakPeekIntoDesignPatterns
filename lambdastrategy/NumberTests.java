package lambdastrategy;

public class NumberTests {
    public static boolean passAll(int x) {
        return true;
    }
    public static boolean isEven(int x) {
        return x % 2 == 0;
    }
    public static boolean isOdd(int x) {
        return x % 2 != 0;
    }
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
    public static boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }
    public static boolean isFibonacci(int x) {
        return isPerfectSquare(5 * x * x + 4) || isPerfectSquare(5 * x * x - 4);
    }
}