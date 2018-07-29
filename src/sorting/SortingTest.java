package sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {

    public static Random mRandom = new Random(System.currentTimeMillis());

    public static void selectionSortTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("selectionSortTest start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = n - i;
        }
        System.out.println("before: " + Arrays.toString(nums));
        Sorting.selectionSort(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("selectionSortTest end");
    }

    public static void insertionSortTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("insertionSortTest start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = mRandom.nextInt(n);
        }
        System.out.println("before: " + Arrays.toString(nums));
        Sorting.insertionSort(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("insertionSortTest end");
    }

    public static void bubbleSortTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("BubbleSortTest start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = mRandom.nextInt(n);
        }
        System.out.println("before: " + Arrays.toString(nums));
        Sorting.bubbleSort(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("BubbleSortTest end");
    }

}
