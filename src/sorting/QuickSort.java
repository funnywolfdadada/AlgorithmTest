package sorting;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int boundary = boundary(nums, start, end);
        //System.out.println(boundary + ", " + Arrays.toString(nums));
        sort(nums, start, boundary - 1);
        sort(nums, boundary + 1, end);
    }

    private static int boundary(int[] nums, int start, int end) {
        int ref = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= ref) {
                j--;
            }
            if(i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[i] <= ref) {
                i++;
            }
            if(i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = ref;
        return i;
    }
}
