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
        int boundary = start;
        for(int i = start + 1; i <= end; i++) {
            if(nums[i] < ref) {
                int tmp = nums[i];
                for(int j = i; j > boundary; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[boundary++] = tmp;
            }
            //System.out.println(boundary + ", " + Arrays.toString(nums));
        }
        return boundary;
    }
}
