package queue.Q4;

public class Q4 {
    /**
     * 스택으로 큐: 스택 두 개로 큐 하나를 구현한 MyQueue 클래스를 구현하라.
     */
    public static void main(String[] args) {
        MyQueue<Integer> my_queue = new MyQueue<Integer>();

        for (int i = 0; i < 5; i++) {
            my_queue.add(i);
            System.out.println("Enqueued " + i);
        }

        for (int k = 0; k < 5; k++) {
            System.out.println("Dequeued " + my_queue.remove());
        }
    }
}
