package stack;

import queue.Queue;

public class QueueStack<T> {
    private Queue<T> mPushQueue = new Queue<>();
    private Queue<T> mPopQueue = new Queue<>();

    public void push(T data) {
        mPushQueue.add(data);
    }

    public T peek() {
        Queue<T> tmp = mPopQueue;
        mPopQueue = mPushQueue;
        mPushQueue = tmp;
        while (mPopQueue.size() > 1) {
            mPushQueue.add(mPopQueue.remove());
        }
        return mPopQueue.peek();
    }

    public T pop() {
        Queue<T> tmp = mPopQueue;
        mPopQueue = mPushQueue;
        mPushQueue = tmp;
        while (mPopQueue.size() > 1) {
            mPushQueue.add(mPopQueue.remove());
        }
        return mPopQueue.remove();
    }

    public int size() {
        return mPopQueue.size() + mPushQueue.size();
    }

}
