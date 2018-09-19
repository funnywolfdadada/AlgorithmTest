package string;

import java.util.HashSet;

public class MaxNonRepSubString {
    public static String get(String string) {
        HashSet<Character> set = new HashSet<>();
        char[] chars = string.toCharArray();
        int maxStart = 0, maxEnd = 0;
        int start = 0, end = 0;
        for (; end < chars.length; end++) {
            if(set.contains(chars[end])) {
                if(end - start > maxEnd - maxStart) {
                    maxEnd = end;
                    maxStart = start;
                }
                while (chars[start] != chars[end]) {
                    set.remove(chars[start]);
                    start++;
                }
                start++;
            }else {
                set.add(chars[end]);
            }
        }
        if(end - start > maxEnd - maxStart) {
            maxEnd = end;
            maxStart = start;
        }
        //System.out.println(maxStart + ", " + maxEnd);
        return string.substring(maxStart, maxEnd);
    }
}
