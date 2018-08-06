package tree;

import queue.Queue;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree {

    private Node mRoot;
    
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
