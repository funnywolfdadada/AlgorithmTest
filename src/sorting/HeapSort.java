package sorting;

public class HeapSort {
    public static int[] heapSort(int[] nums) {
        maxHeapAdjust(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxHeapAdjust(nums, 0, i - 1);
        }
        return nums;
    }

    private static void maxHeapAdjust(int[] nums) {
        for(int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapAdjust(nums, i, nums.length - 1);
        }
    }

    private static void maxHeapAdjust(int[] nums, int start, int end) {
        int index = start * 2 + 1;
        if(index > end) {
            return;
        }
        if(index + 1 <= end && nums[index + 1] > nums[index]) {
            index++;
        }
        if(nums[index] > nums[start]) {
            swap(nums, start, index);
            maxHeapAdjust(nums, index, end);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
