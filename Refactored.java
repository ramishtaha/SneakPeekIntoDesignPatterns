import java.util.List;
import java.util.function.Predicate;

public class Refactored {
    public static int sumByTest(List<Integer> nums, Predicate<Integer> selector){
        int sum = 0;
        for(int num: nums) {
            if(selector.test(num)) {
                sum += num;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumByTest(List.of(1,2,3,4,5,6), (x) -> true));
        System.out.println(sumByTest(List.of(1,2,3,4,5,6), (x) -> x % 2 == 0));
        System.out.println(sumByTest(List.of(1,2,3,4,5,6), (x) -> x % 2 != 0));
    }
}