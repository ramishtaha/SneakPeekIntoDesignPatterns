package lambdastrategy;
import java.util.List;
import java.util.function.Predicate;

public class BetterRefactored {
    public static int betterSumByTest(List<Integer> nums,Boolean And, List<Predicate<Integer>> selectors){
        Predicate<Integer> combinedPredicate = selectors.stream().reduce(Predicate::or).orElse(x -> false);
        if (And) {
            combinedPredicate = selectors.stream().reduce(Predicate::and).orElse(x -> true);
        }
        return nums.stream()
            .filter(combinedPredicate)
            .mapToInt(Integer::intValue).sum();
    }
    public static int betterSumByTest(List<Integer> nums, Predicate<Integer> selectors){
        return nums.stream()
            .filter(selectors)
            .mapToInt(Integer::intValue).sum();
    }
    public static void main(String[] args) {
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), NumberTests::passAll));
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), false, List.of(NumberTests::isEven, NumberTests::isOdd)));
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), true, List.of(NumberTests::isEven, NumberTests::isOdd)));
    }
}
