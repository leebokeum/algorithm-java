package stack;

import java.util.EmptyStackException;

public class MyStack <T>{
    private static class StackNode <T>{
        private T data;
        private StackNode<T> next;
        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    /**
     * 스택에서 가장 위에 있는 항목을 제거한다.
     */
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    /**
     * item 하나를 스택의 가장 윗 부분에 추가한다.
     * @param item
     */
    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    /**
     * 스택의 가장 위에 있는 항목을 반환한다.
     * @return
     */
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    /**
     * 스택이 비어 있을 때에 true를 반환한다
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }
}
