package list;

public class SimpleList<T> {
    private Node<T> mHead = new Node<>(null);
    //private Node<T> mTail = null;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public T get(int position) {
        if(position < 0 || position >= length || mHead.next == null) {
            return null;
        }
        Node<T> p = mHead.next;
        while (position-- > 0) {
            p = p.next;
        }
        return p.data;
    }

    public void insert(int position, T data) {
        if(position < 0 || position > length) {
            return;
        }
        Node<T> p = mHead;
        while (position-- > 0) {
            p = p.next;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = p.next;
        p.next = newNode;
        length++;
    }

    public void remove(int position) {
        if(position < 0 || position >= length) {
            return;
        }
        Node<T> p = mHead;
        while (position-- > 0) {
            p = p.next;
        }
        Node<T> tmp = p.next;
        p.next = p.next.next;
        tmp.next = null;
        length--;
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
        Node<T> fast = mHead.next;
        while (position-- > 0) {
            fast = fast.next;
        }
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
}
