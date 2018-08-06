package array;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    private static Random mRandom = new Random(System.currentTimeMillis());

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
        FullArray.fullArray(nums, 0, n - 1);
        System.out.println("fullArrayTest end");
    }

    public static void arrayMaxMinTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("arrayMaxMinTest start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = mRandom.nextInt(n);
        }
        System.out.println("Array: " + Arrays.toString(nums));
        ArrayMaxMin.getMaxMin(nums);
        System.out.println("max = " + ArrayMaxMin.mMax + ", min = " + ArrayMaxMin.mMin);
        System.out.println("arrayMaxMinTest end");
    }

}
