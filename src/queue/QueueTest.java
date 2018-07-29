package queue;

public class QueueTest {

    public static void queueTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("queueTest start");
        Queue<Integer> queue = new Queue<>();
        for(int i = 0; i < n; i++) {
            queue.add(i);
            System.out.println("add: " + i);
        }
        for(int i = 0; i < n; i++) {
            System.out.println("remove: " + queue.remove());
        }
        System.out.println("queueTest end");
    }

    public static void stackQueueTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("stackQueueTest start");
        StackQueue<Integer> queue = new StackQueue<>();
        for(int i = 0; i < n; i++) {
            queue.add(i);
            System.out.println("add: " + i);
        }
        for(int i = 0; i < n; i++) {
            System.out.println("remove: " + queue.remove());
        }
        System.out.println("stackQueueTest end");
    }

}
