package queue;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
    List<T> mList = new LinkedList<>();

    public void add(T data) {
        mList.add(data);
    }

    public T peek() {
        return mList.size() == 0 ? null : mList.get(0);
    }

    public T remove() {
        return mList.size() == 0 ? null : mList.remove(0);
    }

    public int size() {
        return mList.size();
    }
}
