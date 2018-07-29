package stack;

import queue.Queue;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

    private List<T> mList = new LinkedList<>();

    public void push(T data) {
        mList.add(0, data);
    }

    public T peek() {
        return mList.size() == 0 ? null : mList.get(0);
    }

    public T pop() {
        return mList.size() == 0 ? null : mList.remove(0);
    }

    public int size() {
        return mList.size();
    }

}
