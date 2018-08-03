import java.util.Arrays;

public class FullArray {
    public static void fullArrayTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("fullArrayTest start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i;
        }
        nums[n - 1] = n - 2;
        fullArray(nums, 0, n - 1);
        System.out.println("fullArrayTest end");
    }

    private static void fullArray(int[] nums, int start, int end) {
        if(start == end) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i = start; i <= end; i++) {
            if(!needSwap(nums, i, end)) {
                continue;
            }
            swap(nums, start, i);
            fullArray(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    private static boolean needSwap(int[] nums, int start, int end) {
        for(int i = start + 1; i <= end; i++) {
            if(nums[start] == nums[i]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
