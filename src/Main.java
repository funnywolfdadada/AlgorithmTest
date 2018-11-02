
import java.util.*;

public class Main {

    static final int LEN = 10;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int area[][] = new int[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                area[i][j] = scanner.nextInt();
                //System.out.print(area[i][j] + " ");
            }
            //System.out.println();
        }
        System.out.println(getMaxArea(area));
    }

    static int getMaxArea(int[][] area) {
        if(area == null || area[0] == null) {
            return 0;
        }
        int len = area[0].length;
        int[][] used = new int[len][len];
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(used[i][j] != 0) {
                    continue;
                }
                int tmp = getMaxArea(area, i, j, len, used);
                if(tmp > maxArea) {
                    maxArea = tmp;
                }
            }
        }
        return maxArea;
    }

    static int getMaxArea(int[][] area, int i, int j, int len, int[][] used) {
        used[i][j] = 1;
        if(area[i][j] == 0) {
            return 0;
        }
        int sum = 0;
        if(i > 0 && used[i - 1][j] == 0) {
            sum += getMaxArea(area, i - 1, j, len, used);
        }
        if(i + 1 < len && used[i + 1][j] == 0) {
            sum += getMaxArea(area, i + 1, j, len, used);
        }

        if(j > 0 && used[i][j - 1] == 0) {
            sum += getMaxArea(area, i, j - 1, len, used);
        }
        if(j + 1 < len && used[i][j + 1] == 0) {
            sum += getMaxArea(area, i, j + 1, len, used);
        }

        return sum + 1;
    }
}
