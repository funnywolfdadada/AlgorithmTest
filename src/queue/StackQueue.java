package queue;

import stack.Stack;

public class StackQueue<T> {
    private Stack<T> mInStack = new Stack<>();
    private Stack<T> mOutStack = new Stack<>();

    public void add(T data) {
        mInStack.push(data);
    }

    public T peek() {
        if(mOutStack.size() == 0) {
            while (mInStack.size() != 0) {
                mOutStack.push(mInStack.pop());
            }
        }
        return mOutStack.peek();
    }

    public T remove() {
        if(mOutStack.size() == 0) {
            while (mInStack.size() != 0) {
                mOutStack.push(mInStack.pop());
            }
        }
        return mOutStack.pop();
    }

    public int size() {
        return mInStack.size() + mOutStack.size();
    }

}
