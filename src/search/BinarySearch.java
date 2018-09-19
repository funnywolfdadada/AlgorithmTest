package search;

public class BinarySearch {

    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length < 1 || !sorted(nums)) {
            return false;
        }
        if(target < nums[0] || target > nums[nums.length - 1]) {
            return false;
        }
        int start = 0, end = nums.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            if(target > nums[mid]) {
                start = mid + 1;
            }else if(target < nums[mid]) {
                end = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    private static boolean sorted(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean inc = nums[1] > nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if(inc) {
                if(nums[i + 1] < nums[i]) {
                    return false;
                }
            }else {
                if(nums[i + 1] > nums[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
