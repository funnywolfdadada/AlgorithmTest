package sorting;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1, tmp);
        return nums;
    }

    private static void sort(int[] array, int first, int last, int[] tmp) {
        if(first < last) {
            int mid = (first + last) / 2;
            sort(array, first, mid, tmp);
            sort(array, mid + 1, last, tmp);
            merge(array, first, mid, last, tmp);
        }
    }

    private static void merge(int[] array, int first, int mid, int last, int[] tmp) {
        int i = first, j = mid + 1, k = 0;
        while (i <= mid && j <= last) {
            if(array[i] < array[j]) {
                tmp[k++] = array[i++];
            }else {
                tmp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= last) {
            tmp[k++] = array[j++];
        }
        for(i = 0; i < k; i++) {
            array[first + i] = tmp[i];
        }
    }

    public static int[] mergeSortNonRecursion(int[] nums) {
        int[] tmp = new int[nums.length];
        int loop = 0;
        for(int k = 2; k < nums.length * 2; k *= 2) {
            for(int first = 0; first < nums.length; first += k) {
                int mid = first + k / 2 - 1;
                if(mid >= nums.length) {
                    break;
                }
                int last = first + k - 1;
                last = last >= nums.length ? nums.length - 1 : last;
                merge(nums, first, mid, last, tmp);
            }
            //System.out.println(++loop + ": " + Arrays.toString(nums));
        }
        return nums;
    }
}
