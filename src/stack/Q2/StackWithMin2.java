package stack.Q2;

import java.io.Serial;
import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
    @Serial
    private static final long serialVersionUID = 1262087648891471626L;

    // 최소값(min)을 저장할 별도 스택
    Stack<Integer> minStack;

    // 생성시 min stack 을 초기화 한다.
    public StackWithMin2() {
        minStack = new Stack<Integer>();
    }

    /**
     * 스택에 값을 추가한다.
     */
    public void push(int value){
        // 추가 한 값이 최소값 보다 작다면, 최소값을 저장하는 스택에 값을 추가한다.
        if (value <= min()) {
            minStack.push(value);
        }

        // 스택에 값을 추가한다.
        super.push(value);
    }

    /**
     * 스택에서 값을 꺼낸다.
     */
    public Integer pop() {
        // 스택에서 값을 꺼낸다.
        int value = super.pop();

        // 꺼낸 값이, 최소값과 같다면, 최소값을 저장하는 스택에서도 값을 꺼낸다.
        if (value == min()) {
            minStack.pop();
        }

        // 꺼낸 값 반환
        return value;
    }

    /**
     * 스택의 최소값을 구한다.
     */
    public int min() {
        if (minStack.isEmpty()) {
            // 최소값 스택이 비어 있다면
            return Integer.MAX_VALUE;
        } else {
            // 최소값 스택의 가장 위(top) 값을 반환
            return minStack.peek();
        }
    }
}