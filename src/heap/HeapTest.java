package heap;

import java.util.Arrays;
import java.util.Random;

public class HeapTest {
    private static Random mRandom = new Random(17);

    public static void heapTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("heapTest start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = mRandom.nextInt(100);
        }
        System.out.println("Array: " + Arrays.toString(nums));
        Heap heap = new Heap(nums);
        System.out.println("to Heap:\n" + heap);
        System.out.println("heapTest end");
    }
}
