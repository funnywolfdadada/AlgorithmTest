package nsums;

import sorting.QuickSort;

public class NSums {

    public static void preProcess(int[] nums) {
        QuickSort.quickSort(nums);
    }

    public static int twoSums(int target, int[] nums, int start, int end) {
        if (start < 0 || start >= end || end >= nums.length) {
            return 0;
        }
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                System.out.println("twoSums: target = " + target + " = " + nums[start] + " + " + nums[end]);
                count++;
                int tmp = nums[start++];
                while (start < end && nums[start] == tmp) {
                    System.out.println("twoSums: target = " + target + " = " + nums[start] + " + " + nums[end]);
                    count++;
                    start++;
                }
                tmp = nums[end--];
                while (start < end && nums[end] == tmp) {
                    System.out.println("twoSums: target = " + target + " = " + nums[start] + " + " + nums[end]);
                    count++;
                    end--;
                }
            }
        }
        return count;
    }

    public static int threeSums(int target, int[] nums, int start, int end) {
        if (start < 0 || start >= end || end >= nums.length) {
            return 0;
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            int tmpTarget = target - nums[i];
            int tmpCount = twoSums(tmpTarget, nums, i + 1, end);
            System.out.println("threeSums: target = " + target + ", current = " + nums[i] + ", tmpTarget = " + tmpTarget + ", tmpCount = " + tmpCount);
            count += tmpCount;
        }
        return count;
    }

    public static int fourSums(int target, int[] nums, int start, int end) {
        if (start < 0 || start >= end || end >= nums.length) {
            return 0;
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            int tmpTarget = target - nums[i];
            int tmpCount = threeSums(tmpTarget, nums, i + 1, end);
            System.out.println("fourSums: target = " + target + ", current = " + nums[i] + ", tmpTarget = " + tmpTarget + ", tmpCount = " + tmpCount);
            count += tmpCount;
        }
        return count;
    }
}
