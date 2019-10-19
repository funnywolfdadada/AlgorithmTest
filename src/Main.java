
import nsums.NSums;

public class Main {

    public static void main(String[] args){
        int[] nums = new int[] {-2, -1, 0, 0, 1, 2};
        int count = NSums.fourSums(0, nums, 0, nums.length - 1);
        System.out.println(count);
    }

}
