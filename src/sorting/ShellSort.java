package sorting;

import java.util.Arrays;

public class ShellSort {
    public static int[] shellSort(int[] nums) {
        int step = nums.length;
        int k = 0;
        do{
            step = step / 3 + 1;
            for(int i = 0; i < step; i++) {
                insert(nums, i, step);
                //System.out.println(++k + ": " + Arrays.toString(nums));
            }
        }while (step > 1);
        return nums;
    }

    private static void insert(int[] nums, int start, int step) {
        for(int i = start + step; i < nums.length; i += step) {
            int tmp = nums[i];
            int j;
            for(j = i - step; j >= start; j -= step) {
                if(nums[j] < tmp) {
                    nums[j + step] = tmp;
                    break;
                }
                nums[j + step] = nums[j];
            }
            if(j < start) {
                nums[j + step] = tmp;
            }
        }
    }
}
