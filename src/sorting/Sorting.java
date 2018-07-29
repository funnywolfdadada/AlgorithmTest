package sorting;

import java.util.Arrays;

public class Sorting {

    public static int[] selectionSort(int[] nums) {
        if(nums == null) {
            return null;
        }
        int k = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            System.out.println(++k + ": " + Arrays.toString(nums));
        }
        return nums;
    }

    public static int[] insertionSort(int[] nums) {
        if(nums == null) {
            return null;
        }
        int k = 0;
        for(int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(nums[j] < tmp) {
                    nums[j + 1] = tmp;
                    break;
                }
                nums[j + 1] = nums[j];
            }
            if(j < 0) {
                nums[0] = tmp;
            }
            System.out.println(++k + ": " + Arrays.toString(nums));
        }
        return nums;
    }

    public static int[] bubbleSort(int[] nums) {
        if(nums == null) {
            return null;
        }
        int k = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 1; j < nums.length - i; j++) {
                if(nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
            System.out.println(++k + ": " + Arrays.toString(nums));
        }
        return nums;
    }

}
