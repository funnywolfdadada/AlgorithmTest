package stack;

public class StackTest {

    public static void stackTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("stackTest start");
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            stack.push(i);
            System.out.println("push: " + i);
        }
        for(int i = 0; i < n; i++) {
            System.out.println("pop: " + stack.pop());
        }
        System.out.println("stackTest end");
    }

    public static void queueStackTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("queueStackTest start");
        QueueStack<Integer> stack = new QueueStack<>();
        for(int i = 0; i < n; i++) {
            stack.push(i);
            System.out.println("push: " + i);
        }
        for(int i = 0; i < n; i++) {
            System.out.println("pop: " + stack.pop());
        }
        System.out.println("queueStackTest end");
    }

}
