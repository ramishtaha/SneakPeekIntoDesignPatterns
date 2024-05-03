package lambdastrategy;
import java.util.List;
import java.util.function.Predicate;

public class BetterRefactored {

    // The betterSumByTest method is overloaded to accept a single predicate
    public static int betterSumByTest(List<Integer> nums, Predicate<Integer> selectors){
        return nums.stream()
            .filter(selectors)
            .mapToInt(Integer::intValue).sum();
    }

    // The betterSumByTest method is overloaded to accept different types of predicates
    public static int betterSumByTest(List<Integer> nums,Boolean And, List<Predicate<Integer>> selectors) {

        // Initialize the combined predicate to OR
        Predicate<Integer> combinedPredicate = selectors.stream().reduce(Predicate::or).orElse(x -> false);

        // If And is true, then change the combined predicate to AND
        if (And) {
            combinedPredicate = selectors.stream().reduce(Predicate::and).orElse(x -> true);
        }

        // Filter the numbers based on the combined predicate and sum them
        return nums.stream()
            .filter(combinedPredicate)
            .mapToInt(Integer::intValue).sum();
    }
    
    public static void main(String[] args) {
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), NumberTests::passAll)); // Returns 108
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), false, List.of(NumberTests::isEven, NumberTests::isOdd))); // Returns 108
        System.out.println(betterSumByTest(List.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15), true, List.of(NumberTests::isEven, NumberTests::isOdd))); // Returns 0
    }
}
