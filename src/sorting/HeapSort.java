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

    public static int[] topK(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return null;
        }
        int[] result = new int[k];
        int i = 0;
        for (; i < k; i++) {
            result[i] = nums[i];
        }
        maxHeapAdjust(result);
        for (; i < nums.length; i++) {
            if(result[0] > nums[i]) {
                result[0] = nums[i];
                maxHeapAdjust(result);
            }
        }
        return result;
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
