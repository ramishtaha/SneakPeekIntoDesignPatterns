import java.util.List;

public class BadCode{
    public static int sum(List<Integer> nums){
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        return sum;
    }
    public static int sumEven(List<Integer> nums){
        int sum = 0;
        for(int num: nums) {
            if(num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }
    public static int sumOdd(List<Integer> nums){
        int sum = 0;
        for(int num: nums) {
            if(num % 2 != 0) {
                sum += num;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sum(List.of(1,2,3,4,5,6)));
        System.out.println(sumEven(List.of(1,2,3,4,5,6)));
        System.out.println(sumOdd(List.of(1,2,3,4,5,6)));
    }
}