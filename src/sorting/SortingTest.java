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

    public static void mergeSortTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("mergeSortTest start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = mRandom.nextInt(n);
        }
        System.out.println("before: " + Arrays.toString(nums));
        Sorting.mergeSort(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("mergeSortTest end");
    }

    public static void mergeSortTestNonRecursion(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("mergeSortTestNonRecursion start");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = n - i;
            //nums[i] = mRandom.nextInt(n);
        }
        System.out.println("before: " + Arrays.toString(nums));
        Sorting.mergeSortNonRecursion(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("mergeSortTestNonRecursion end");
    }

    public static void quickSortTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("quickSortTest start");
        int[] nums = new int[n];
        nums[0] = n / 2;
        for(int i = 1; i < n; i++) {
            //nums[i] = n - i;
            nums[i] = mRandom.nextInt(n);
        }
        System.out.println("before: " + Arrays.toString(nums));
        Sorting.quickSort(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("quickSortTest end");
    }

    public static void shellSortTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("shellSortTest start");
        int[] nums = new int[n];
        nums[0] = n / 2;
        for(int i = 1; i < n; i++) {
            //nums[i] = n - i;
            nums[i] = mRandom.nextInt(n);
        }
        System.out.println("before: " + Arrays.toString(nums));
        Sorting.shellSort(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("shellSortTest end");
    }

    public static void heapSortTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("heapSortTest start");
        int[] nums = new int[n];
        nums[0] = n / 2;
        for(int i = 1; i < n; i++) {
            //nums[i] = n - i;
            nums[i] = mRandom.nextInt(n);
        }
        System.out.println("before: " + Arrays.toString(nums));
        HeapSort.heapSort(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println("heapSortTest end");
    }

    public static void speedTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("speedTest start: " + n + " samples");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = mRandom.nextInt(n);
        }
        long t;
        /*
        t = System.currentTimeMillis();
        Sorting.selectionSort(nums.clone());
        System.out.println("selectionSort: " + (System.currentTimeMillis() - t) + "ms");

        t = System.currentTimeMillis();
        Sorting.bubbleSort(nums.clone());
        System.out.println("bubbleSort: " + (System.currentTimeMillis() - t) + "ms");
        */
        t = System.currentTimeMillis();
        Sorting.insertionSort(nums.clone());
        System.out.println("insertionSort: " + (System.currentTimeMillis() - t) + "ms");

        t = System.currentTimeMillis();
        Sorting.mergeSort(nums.clone());
        System.out.println("mergeSort: " + (System.currentTimeMillis() - t) + "ms");

        t = System.currentTimeMillis();
        Sorting.mergeSortNonRecursion(nums.clone());
        System.out.println("mergeSortNonRecursion: " + (System.currentTimeMillis() - t) + "ms");

        t = System.currentTimeMillis();
        Sorting.quickSort(nums.clone());
        System.out.println("quickSort: " + (System.currentTimeMillis() - t) + "ms");

        t = System.currentTimeMillis();
        Sorting.shellSort(nums.clone());
        System.out.println("shellSort: " + (System.currentTimeMillis() - t) + "ms");

        t = System.currentTimeMillis();
        Sorting.heapSort(nums.clone());
        System.out.println("heapSort: " + (System.currentTimeMillis() - t) + "ms");

        System.out.println("speedTest end");
    }

}
