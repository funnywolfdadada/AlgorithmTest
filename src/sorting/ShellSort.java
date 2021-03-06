package sorting;

import java.util.Arrays;

public class ShellSort {
    public static int[] shellSort(int[] nums) {
        //int k = 0;
        for (int step = nums.length / 2; step > 0; step /= 2){
            for(int i = 0; i < step; i++) {
                insert(nums, i, step);
                //System.out.println(++k + ": " + Arrays.toString(nums));
            }
        }
        return nums;
    }

    private static void insert(int[] nums, int start, int step) {
        for(int i = start + step; i < nums.length; i += step) {
            int tmp = nums[i];
            int j = i - step;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + step] = nums[j];
                j -= step;
            }
            nums[j + step] = tmp;
        }
    }
}
