package array;

public class MaxSubSum {

    public static int maxSubSum(int[] nums) {
        int maxSum = 0;//Integer.MIN_VALUE;
        int tempSum = 0;
        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            if(tempSum > 0) {
                tempSum += nums[i];
            }else {
                tempSum = nums[i];
                start = i;
            }
            if(tempSum > maxSum) {
                maxSum = tempSum;
                end = i;
            }
        }
        //System.out.println(start + ", " + end + ", " + maxSum);
        return maxSum;
    }

}
