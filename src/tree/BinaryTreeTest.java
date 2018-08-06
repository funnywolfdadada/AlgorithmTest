package tree;

import java.util.Arrays;
import java.util.Random;

public class BinaryTreeTest {
    public static void binaryTreeTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("binaryTreeTest start");
        Random random = new Random(System.currentTimeMillis());
        int[] nums = new int[n];
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < n; i++) {
            nums[i] = random.nextInt(n);
            tree.insert(nums[i]);
        }
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("preOrder: " + tree.preOrder());
        System.out.println("inOrder: " + tree.inOrder());
        System.out.println("postOrder: " + tree.postOrder());
        System.out.println("layerOrder: " + tree.layerOrder());
        System.out.println("maxDepth: " + tree.maxDepth());
        System.out.println("maxDistance: " + tree.maxDistance());
        System.out.println("binaryTreeTest end");
    }
}
