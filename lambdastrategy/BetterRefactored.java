package lambdastrategy;
import java.util.List;
import java.util.function.Predicate;

public class BetterRefactored {
    public static int betterSumByTest(List<Integer> nums, Predicate<Integer> selector){
        return nums.stream()
            .filter(selector)
            .mapToInt(Integer::intValue).sum();
    }
    public static void main(String[] args) {
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), NumberTests::passAll));
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6), NumberTests::isEven));
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), NumberTests::isEven));
    }
}
