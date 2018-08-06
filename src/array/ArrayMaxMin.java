package array;

import java.util.Random;

public class ArrayMaxMin {
    public static int mMax;
    public static int mMin;

    public static void getMaxMin(int[] nums) {
        mMax = mMin = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < mMin) {
                mMin = nums[i];
            }else if(nums[i] > mMax) {
                mMax = nums[i];
            }
        }
    }
}
