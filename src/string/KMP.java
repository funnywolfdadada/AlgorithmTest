package string;

import java.util.Arrays;

public class KMP {
    public static int indexOf(String source, String target) {
        int sourceLength = source.length();
        int targetLength = target.length();
        if(targetLength > sourceLength) {
            return -1;
        }
        int[] next = generateIndexes(target);
        //System.out.println(Arrays.toString(next));
        int i = 0, j = 0;
        while (i < sourceLength && j < targetLength) {
            if(source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            }else if(j > 0) {
                j = next[j - 1];
            }else {
                i++;
            }
        }
        if(j == targetLength) {
            return i - targetLength + 1;
        }
        return -1;
    }

    public static int[] generateIndexes(String string) {
        int[] next = new int[string.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < next.length; i++) {
            if(string.charAt(i) == string.charAt(j)) {
                j++;
            }else {
                j = 0;
            }
            next[i] = j;
        }
        return next;
    }
}
