package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> mArray;

    public Heap(int[] nums) {
        mArray = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            mArray.add(nums[i]);
        }
        initMinHeap();
    }

    public void sort() {
        System.out.println(mArray);
        for(int i = mArray.size() - 1; i >= 1; i--) {
            swap(i, 0);
            adjustMinHeap(0, i - 1);
            System.out.println(mArray);
        }
    }

    private void initMinHeap() {
        System.out.println(toString());
        for(int i = mArray.size() / 2 - 1; i >= 0; i--) {
            adjustMinHeap(i, mArray.size() - 1);
            System.out.println(toString());
        }
    }

    private void adjustMinHeap(int parent, int end) {
        for(int child = parent * 2 + 1; child <= end; child++) {
            if(mArray.get(child) < mArray.get(parent)) {
                swap(child, parent);
                adjustMinHeap(child, end);
            }
        }
    }

    private void swap(int index1, int index2) {
        int tmp = mArray.get(index1);
        mArray.set(index1, mArray.get(index2));
        mArray.set(index2, tmp);
    }

    private int getMaxLevel() {
        int maxLevel = 0;
        for(int len = mArray.size(); len > 0; len >>= 1) {
            maxLevel++;
        }
        return maxLevel;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int maxLevel = getMaxLevel();
        for(int i = 0, level = 1; level <= maxLevel; level++) {
            builder.append(String.format("\t%1d:\t", level));
            int end = (1 << level) - 1;
            for(; i < end && i < mArray.size(); i++) {
                builder.append(mArray.get(i));
                for(int j = 0; j < (1<<(maxLevel - level)); j++) {
                    builder.append('\t');
                }
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
