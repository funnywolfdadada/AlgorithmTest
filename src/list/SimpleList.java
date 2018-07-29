package list;

import stack.Stack;

import java.util.HashSet;

public class SimpleList<T> {
    private Node<T> mHead = new Node<>(null);
    //private Node<T> mTail = null;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public T get(int position) {
        Node<T> node = getNode(position);
        return node == null ? null : node.data;
    }

    public void insert(int position, T data) {
        if(position < 0 || position > length) {
            return;
        }
        Node<T> prev = position == 0 ? mHead : getNode(position - 1);
        Node<T> newNode = new Node<>(data);
        newNode.next = prev.next;
        prev.next = newNode;
        length++;
    }

    public void remove(int position) {
        if(position < 0 || position >= length) {
            return;
        }
        removeNode(position == 0 ? mHead : getNode(position - 1));
    }

    public void reverse() {
        if(mHead.next == null) {
            return;
        }
        Node<T> p = mHead.next;
        while (p.next != null) {
            Node<T> tmp = p.next;
            p.next = p.next.next;
            tmp.next = mHead.next;
            mHead.next = tmp;
        }
    }

    public T getFromTail(int position) {
        if(position < 0 || position >= length) {
            return null;
        }
        Node<T> fast = getNode(position);
        Node<T> slow = mHead.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public T getMiddle() {
        if(mHead.next == null) {
            return null;
        }
        Node<T> fast = mHead.next;
        Node<T> slow = mHead.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public void removeDuplicate() {
        if(mHead.next == null) {
            return;
        }
        HashSet<T> set = new HashSet<>();
        Node<T> p = mHead;
        while (p.next != null) {
            if(!set.add(p.next.data)) {
                removeNode(p);
                continue;
            }
            p = p.next;
        }
    }

    public void tailPointTo(int position) {
        if(position < 0 || position >= length) {
            return;
        }
        Node<T> p = mHead.next;
        while (position-- > 0) {
            p = p.next;
        }
        Node<T> tmp = p;
        while (p.next != null) {
            p = p.next;
        }
        p.next = tmp;
    }

    public boolean isLoop() {
        if(mHead.next == null) {
            return false;
        }
        Node<T> fast = mHead.next;
        Node<T> slow = mHead.next;
        while (fast != null && fast.next != null) {
            if(fast.next == slow || fast.next.next == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public void tailPointTo(SimpleList<T> list, int position) {
        if(mHead.next == null || list.getLength() <= position || position < 0) {
            return;
        }
        getTailNode().next = list.getNode(position);
        length += list.getLength() - position;
    }

    public boolean isIntersect(SimpleList<T> list) {
        if(mHead.next == null || list.getLength() == 0) {
            return false;
        }
        return getTailNode() == list.getTailNode();
    }

    public int intersectAt(SimpleList<T> list) {
        if(mHead.next == null || list.getLength() == 0) {
            return -1;
        }
        int position = 0;
        Node<T> p1, p2;
        if(length > list.getLength()) {
            position = length - list.getLength();
            p1 = getNode(position);
            p2 = list.getHeadNode();
        } else {
            p1 = getHeadNode();
            p2 = list.getNode(list.getLength() - length);
        }
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            position++;
            if(p1 == p2) {
                return position;
            }
        }
        return -1;
    }

    private Node<T> getNode(int position) {
        if(position < 0 || position >= length) {
            return null;
        }
        Node<T> node = mHead.next;
        while (position-- > 0) {
            node = node.next;
        }
        return node;
    }

    public Node<T> getHeadNode() {
        return mHead.next;
    }

    public Node<T> getTailNode() {
        if(mHead.next == null) {
            return null;
        }
        Node<T> tail = mHead.next;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public String toStringFromTail() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> p = mHead.next;
        Stack<T> stack = new Stack<>();
        while (p != null) {
            stack.push(p.data);
            p = p.next;
        }
        while (stack.size() > 0) {
            builder.append(stack.pop().toString());
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> p = mHead.next;
        while (p != null) {
            builder.append(p.data.toString());
            builder.append(", ");
            p = p.next;
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    private void removeNode(Node<T> prev) {
        Node<T> tmp = prev.next;
        prev.next = prev.next.next;
        tmp.next = null;
        length--;
    }
}
