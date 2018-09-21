import array.MaxSubSum;
import list.ListTest;
import sorting.Sorting;
import sorting.SortingTest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args){
        //SortingTest.heapSortTest(10);
        //SortingTest.topKTest(10, 5);
        //SortingTest.speedTest(100000);
        //SortingTest.binaryInsertionSortTest(10);
        Random random = new Random(System.currentTimeMillis());
        int[] nums = new int[10000000];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt() % 256;
        }
        long t;
        int max;

        t = System.currentTimeMillis();
        max = MaxSubSum.maxSubSum5(nums);
        t = System.currentTimeMillis() - t;
        System.out.println(t + ": " + max);

        t = System.currentTimeMillis();
        max = MaxSubSum.maxSubSum(nums);
        t = System.currentTimeMillis() - t;
        System.out.println(t + ": " + max);
    }

}
