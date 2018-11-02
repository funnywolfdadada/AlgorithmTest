package array;

import sorting.Sorting;

import java.util.Arrays;

public class SumEqual {
    public static int[] sumEqual(int[] nums, int sum) {
        int[] result = null;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmpSum = nums[i] + nums[j];
            if(tmpSum > sum) {
                j--;
            }else if (tmpSum < sum){
                i++;
            }else {
                result = new int[]{nums[i], nums[j]};
                break;
            }
        }
        return result;
    }

}
