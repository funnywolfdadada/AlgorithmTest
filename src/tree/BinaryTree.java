package tree;

import queue.Queue;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree {

    private Node mRoot;

    public BinaryTree() {}

    public BinaryTree(int[] nums) {
        super();
        for(int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public BinaryTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        if(preOrder == null || inOrder == null || preOrder.size() != inOrder.size()) {
            return;
        }
        mRoot = build(preOrder, 0, preOrder.size() - 1,
                inOrder, 0, inOrder.size() - 1);
    }

    private Node build(ArrayList<Integer> preOrder, int preStart, int preEnd,
                       ArrayList<Integer> inOrder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        Node root = new Node(preOrder.get(preStart));
        for(int i = inStart; i <= inEnd; i++) {
            if(inOrder.get(i).equals(preOrder.get(preStart))) {
                int offset = i - inStart;
                root.mLeft = build(preOrder, preStart + 1, preStart + offset,
                        inOrder, inStart, i - 1);
                root.mRight = build(preOrder, preStart + offset + 1, preEnd,
                        inOrder, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    public Node insert(int data) {
        Node node = new Node(data);
        if(mRoot == null) {
            mRoot = node;
        }else {
            Node current = mRoot, parent;
            while (true) {
                parent = current;
                if(current.mData < node.mData) {
                    current = current.mRight;
                    if(current == null) {
                        parent.mRight = node;
                        break;
                    }
                }else {
                    current = current.mLeft;
                    if(current == null) {
                        parent.mLeft = node;
                        break;
                    }
                }
            }
        }
        return node;
    }

    private void inOrder(Node node, ArrayList<Integer> result) {
        if(node != null) {
            inOrder(node.mLeft, result);
            result.add(node.mData);
            inOrder(node.mRight, result);
        }
    }

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(mRoot, result);
        return result;
    }

    private void preOrder(Node node, ArrayList<Integer> result) {
        if(node != null) {
            result.add(node.mData);
            preOrder(node.mLeft, result);
            preOrder(node.mRight, result);
        }
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(mRoot, result);
        return result;
    }

    private void postOrder(Node node, ArrayList<Integer> result) {
        if(node != null) {
            postOrder(node.mLeft, result);
            postOrder(node.mRight, result);
            result.add(node.mData);
        }
    }

    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(mRoot, result);
        return result;
    }

    public ArrayList<Integer> layerOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new Queue<>();
        queue.add(mRoot);
        while (queue.size() != 0) {
            Node node = queue.remove();
            result.add(node.mData);
            if(node.mLeft != null) {
                queue.add(node.mLeft);
            }
            if(node.mRight != null) {
                queue.add(node.mRight);
            }
        }
        return result;
    }

    public int maxDepth() {
        return maxDepth(mRoot);
    }

    private int maxDepth(Node node) {
        int depth = 0;
        if(node != null) {
            int maxLeftDepth = maxDepth(node.mLeft);
            int maxRightDepth = maxDepth(node.mRight);
            depth = Math.max(maxLeftDepth, maxRightDepth) + 1;
        }
        return depth;
    }

    public int maxDistance() {
        return maxDepth(mRoot.mRight) + maxDepth(mRoot.mLeft) + 1;
    }

    public static class Node {
        public int mData;
        public Node mLeft = null;
        public Node mRight = null;

        public Node(int data) {
            mData = data;
        }
    }    
}
