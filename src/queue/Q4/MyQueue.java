package queue.Q4;

import java.util.Stack;

/**
 * 두개의 스택으로 Queue 구현하기
 */
public class MyQueue<T>  {

    // 두개의 스택
    Stack<T> stackNewest, stackOldest;

    // 생성시 두개의 스택 초기화
    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    /**
     * 큐의 전체 사이즈 : 두개의 스택 사이즈를 더하면 전체 큐 사이즈가 된다.
     */
    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    /**
     * 큐에 값 추가
     */
    public void add(T value) {
        // 값을 추가할 때는 첫번째 스택(stackNewest)에만 쌓는다.
        stackNewest.push(value);
    }

    /**
     * 스택의 값 옮기기
     * stackNewest 스택에서 stackOldest 로 값을 이동 시킨다.
     */
    private void shiftStacks() {
        // stackOldest 에 값이 비어있을 때만 수행한다.
        if (stackOldest.isEmpty()) {
            // stackNewest 에 있는 값 전부를 stackOldest 에 이동 시킨다.
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    /**
     * 큐에 가장 앞에 있는 값 보기
     */
    public T peek() {
        // 1. 스택의 값을 옮기고
        shiftStacks();

        // 2. stackOldest 의 가장 위(top)에 있는 값을 보여준다.
        return stackOldest.peek();
    }

    /**
     * 큐의 값 꺼내기
     */
    public T remove() {
        // 1. 스택의 값을 옮기고
        shiftStacks();

        // 2. stackOldest 의 가장 위(top)에 있는 값을 꺼낸다.
        return stackOldest.pop();
    }
}
